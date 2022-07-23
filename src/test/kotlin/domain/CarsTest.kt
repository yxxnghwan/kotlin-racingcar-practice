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
    }
}