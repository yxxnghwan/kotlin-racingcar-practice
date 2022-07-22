package domain

import exception.CarNameLengthException

private const val MAX_CAR_NAME_LENGTH = 5

class Car private constructor(carName: String, private var position: Int = 0) {

    constructor(carName: String) : this(carName, 0)

    init {
        validateName(carName)
    }

    private fun validateName(carName: String) {
        if (isInvalidCarNameLength(carName)) {
            throw CarNameLengthException(carName)
        }
    }

    private fun isInvalidCarNameLength(carName: String) = carName.isEmpty() || carName.length > MAX_CAR_NAME_LENGTH
}