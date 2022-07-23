package domain

import exception.CarNameLengthException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarTest : FunSpec() {

    init {
        test("자동차 이름이 1글자 이상 5글자 이하가 아닌 경우 예외가 발생한다.") {
            listOf("aaaaaa", "").forEach { carName ->
                shouldThrow<CarNameLengthException> { Car(carName) {true} }
            }
        }

        test("자동차가 이동에 성공하면 위치값이 1씩 증가한다.") {
            val car = Car("alex") { true }
            car.move()
            println(car.carName)
            car.position shouldBe 1
        }
    }
}