package domain

class Cars(val value: List<Car>) {

    fun moveAll() {
        for (car in value) {
            car.move()
        }
    }

    fun getWinners() : List<Car> {
        val maxPosition = value.stream()
            .mapToInt { car -> car.position }
            .max()
            .orElseGet { 0 }

        return value.filter { car -> car.position == maxPosition }
    }
}