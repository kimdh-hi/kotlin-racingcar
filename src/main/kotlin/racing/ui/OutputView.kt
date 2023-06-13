package racing.ui

import racing.domain.RacingPhaseRecords

object OutputView {

    fun print(racingPhaseRecords: List<RacingPhaseRecords>) {
        println("실행 결과")
        racingPhaseRecords.forEach { phaseRecords ->
            printRacingResult(phaseRecords)
            println()
        }

        printWinners(racingPhaseRecords)
    }

    private fun printRacingResult(racingPhaseRecords: RacingPhaseRecords) {
        racingPhaseRecords.records.forEach { record ->
            print("${record.carName} : ")
            println("-".repeat(record.distance))
        }
    }

    private fun printWinners(racingPhaseRecords: List<RacingPhaseRecords>) {
        val winners = racingPhaseRecords.last().getWinners()
        println("${winners.joinToString(",")}가 최종 우승했습니다.")
    }
}
