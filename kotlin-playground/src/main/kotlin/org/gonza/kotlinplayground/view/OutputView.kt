package org.gonza.kotlinplayground.view

import org.gonza.kotlinplayground.domain.Cars

class OutputView {
    fun roundPosition(raceResult: List<Cars>) {
        println("실행 결과")
        for (cars in raceResult) {
            println(cars.positions())
            println()
        }
    }

    fun winner(raceResult: List<Cars>) {
        val winners = raceResult.last().winners()
        println("${winners}가 최종 우승했습니다.")
    }
}
