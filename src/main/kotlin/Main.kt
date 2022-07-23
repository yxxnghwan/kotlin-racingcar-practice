import domain.Car
import domain.Cars
import domain.RandomMoveStrategy
import dto.RoundResult
import view.InputView
import view.OutputView

fun main(args: Array<String>) {
    val inputView = InputView()
    val outputView = OutputView()

    val cars = initCars(inputView)
    val round = inputView.inputRound()

    playRound(outputView, round, cars)
    printWinners(cars, outputView)
}

private fun initCars(inputView: InputView): Cars {
    val carNames = inputView.inputCarNames()
    val carsValue = carNames.map { carName -> Car(carName, RandomMoveStrategy()) }
    return Cars(carsValue)
}

private fun playRound(outputView: OutputView, round: Int, cars: Cars) {
    outputView.printResultMessage()
    for (i: Int in 0..round) {
        cars.moveAll()
        val roundResults = extractRoundResults(cars)
        outputView.printRoundResult(roundResults)
    }
}

private fun extractRoundResults(cars: Cars) : List<RoundResult> {
    return cars.value
        .map { car -> RoundResult(car.carName, car.position) }
}

private fun printWinners(cars: Cars, outputView: OutputView) {
    val winners = cars.getWinners()
    outputView.printWinners(winners.map { car -> car.carName })
}
