package domain

private const val MOVE_STANDARD = 4
private const val MIN_RANDOM_NUMBER_VALUE = 1
private const val MAX_RANDOM_NUMBER_VALUE = 9

class RandomMoveStrategy : MoveStrategy {

    override fun isMovable(): Boolean {
        if (getRandomNumber() >= MOVE_STANDARD) {
            return true
        }
        return false
    }

    private fun getRandomNumber(): Int {
        val range = (MIN_RANDOM_NUMBER_VALUE..MAX_RANDOM_NUMBER_VALUE)
        return range.random()
    }
}