package domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : FunSpec() {

    init {
        test("모든 자동차에 이동 명령을 준다.") {
            val carsValue = listOf(Car("alex1") { true }, Car("alex2") { true }, Car("alex3") { true })
            val cars = Cars(carsValue)
            cars.moveAll()
            cars.moveAll()
            cars.value.forEach { car -> car.position shouldBe 2 }
        }

        test("자동차의 우승자를 찾아낸다.") {
            val carName1 = "alex1"
            val carName3 = "alex3"
            val carsValue = listOf(Car(carName1) { true }, Car("alex2") { false }, Car(carName3) { true })
            val cars = Cars(carsValue)
            cars.moveAll()

            val winners = cars.getWinners()
            val carNames = winners.map { car -> car.carName }

            carNames shouldBe listOf(carName1, carName3)
        }
    }
}