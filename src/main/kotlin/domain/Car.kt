package domain

import exception.CarNameLengthException

private const val MAX_CAR_NAME_LENGTH = 5

class Car (val carName: String, private val moveStrategy: MoveStrategy) {

    var position: Int = 0
    private set


    init {
        validateName(carName)
    }

    private fun validateName(carName: String) {
        if (isInvalidCarNameLength(carName)) {
            throw CarNameLengthException(carName)
        }
    }

    private fun isInvalidCarNameLength(carName: String) = carName.isEmpty() || carName.length > MAX_CAR_NAME_LENGTH

    fun move() {
        if (moveStrategy.isMovable()) {
            position++
        }
    }
}