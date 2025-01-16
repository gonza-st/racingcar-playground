package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.dto.RaceParticipants

class GameBoard(
    val raceParticipants: RaceParticipants,
    val strategy: MoveStrategy,
) {
    fun run() {
        raceParticipants.cars.forEach {
            it.moveForward(strategy.determineNextMove())
        }
    }
}
