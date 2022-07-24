package view

import dto.RoundResult

class OutputView {

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printRoundResult(results: List<RoundResult>) {
        results.forEach { result -> println("${result.carName} : ${"-".repeat(result.position)}") }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }

    fun printError(message: String?) {
        println(message)
    }
}
