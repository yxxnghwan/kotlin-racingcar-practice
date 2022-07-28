package domain

class Car (_carName: String, private val moveStrategy: MoveStrategy) {

    var position: Int = 0
    private set

    var carName: CarName = CarName(_carName)

    fun move() {
        if (moveStrategy.isMovable()) {
            position++
        }
    }

    fun getCarName() : String {
        return carName.value
    }
}