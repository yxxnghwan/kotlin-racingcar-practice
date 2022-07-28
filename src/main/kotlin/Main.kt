import domain.Car
import domain.Cars
import domain.RandomMoveStrategy
import dto.RoundResult
import exception.CarNameLengthException
import view.InputView
import view.OutputView

val inputView = InputView()
val outputView = OutputView()

fun main(args: Array<String>) {
    val cars = initCars()
    val round = inputRound()

    playRound(round, cars)
    printWinners(cars)
}

private fun initCars(): Cars {
    val carNames = inputView.inputCarNames()
    return try {
        val carsValue = carNames.map { carName -> Car(carName, RandomMoveStrategy()) }
        Cars(carsValue)
    } catch (e: CarNameLengthException) {
        outputView.printError(e.message)
        initCars()
    }
}

private fun inputRound(): Int {
    return try {
        inputView.inputRound()
    } catch (e: NumberFormatException) {
        outputView.printError("아 숫자 입력하라고요")
        inputRound()
    }
}

private fun playRound(round: Int, cars: Cars) {
    outputView.printResultMessage()
    for (i: Int in 0..round) {
        cars.moveAll()
        val roundResults = extractRoundResults(cars)
        outputView.printRoundResult(roundResults)
    }
}

private fun extractRoundResults(cars: Cars) : List<RoundResult> {
    return cars.value
        .map { car -> RoundResult(car.getCarName(), car.position) }
}

private fun printWinners(cars: Cars) {
    val winners = cars.getWinners()
    outputView.printWinners(winners.map { car -> car.getCarName() })
}
