package domain

import exception.CarNameLengthException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec

internal class CarTest : FreeSpec() {
    init {
        "자동차 이름이 1글자 이상 5글자 이하가 아닌 경우 예외가 발생한다." - {
            listOf("aaaaaa", "").forEach { carName ->
                shouldThrow<CarNameLengthException> { Car(carName) }
            }
        }
    }
}