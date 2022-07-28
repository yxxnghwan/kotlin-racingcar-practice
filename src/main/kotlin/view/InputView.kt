package view

private const val NAME_DELIMITER = ","

class InputView() {

    fun inputCarNames() : List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val nameInput = readLine()
        return nameInput!!.split(NAME_DELIMITER)
    }

    fun inputRound() : Int {
        println("시도할 회수는 몇회인가요?")
        val rawRound = readLine()
        return rawRound!!.toInt()
    }
}