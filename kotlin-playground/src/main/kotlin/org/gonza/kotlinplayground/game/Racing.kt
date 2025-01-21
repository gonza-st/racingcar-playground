package org.gonza.kotlinplayground.game

import org.gonza.kotlinplayground.racer.Racer
import org.gonza.kotlinplayground.racer.Racers
import org.gonza.kotlinplayground.rule.Judge

class Racing(
    private val racers: Racers,
    private val judge: Judge
) {
    fun play(turns: Int) {
        racers.race(turns)
        val winners = judge.winner(racers.getRacers())
        announceWinners(winners)
    }

    private fun announceWinners(winners: List<Racer>) {
        println("\n${winners.joinToString(", ") { it.car.name }}가 최종 우승했습니다.")
    }
}