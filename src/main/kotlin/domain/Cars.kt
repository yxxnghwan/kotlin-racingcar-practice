package domain

class Cars(val value: List<Car>) {

    fun moveAll() {
        for (car in value) {
            car.move()
        }
    }
}