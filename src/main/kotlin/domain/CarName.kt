package domain

import exception.CarNameLengthException

private const val MAX_CAR_NAME_LENGTH = 5

class CarName(val value: String) {

    init {
        validateName(value)
    }

    private fun validateName(carName: String) {
        if (isInvalidCarNameLength(carName)) {
            throw CarNameLengthException(carName)
        }
    }

    private fun isInvalidCarNameLength(carName: String) = carName.isEmpty() || carName.length > MAX_CAR_NAME_LENGTH
}
