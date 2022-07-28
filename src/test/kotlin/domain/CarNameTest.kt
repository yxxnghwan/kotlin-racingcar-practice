package domain

import exception.CarNameLengthException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

internal class CarNameTest : FunSpec() {

    init {
        test("자동차 이름은 1글자 이상 5글자 이하여야 한다.") {
            listOf("aaaaaa", "").forEach { carName ->
                shouldThrow<CarNameLengthException> { CarName(carName) }
            }
        }
    }
}