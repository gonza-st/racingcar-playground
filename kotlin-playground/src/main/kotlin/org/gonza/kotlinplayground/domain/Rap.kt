package org.gonza.kotlinplayground.domain

class Rap(private var round: Int) {
    private var currentRap = 0

    fun getRound() = round

    fun getCurrentRap() = currentRap

    fun increaseRound() = currentRap++

    fun decreaseRound() = currentRap--
}