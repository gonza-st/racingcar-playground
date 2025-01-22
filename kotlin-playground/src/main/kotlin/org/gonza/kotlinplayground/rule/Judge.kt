package org.gonza.kotlinplayground.rule

import org.gonza.kotlinplayground.racer.Racer

class Judge {
    fun winner(racers : List<Racer>): List<Racer> {
        val maxLocation = racers.maxOf { it.car.location }
        return racers.filter { it.car.location == maxLocation }
    }
}
