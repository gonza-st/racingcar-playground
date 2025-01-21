package org.gonza.kotlinplayground.domain.racing

class Round(
    var value: Int
) {
    init {
        if(value < 0) {
            throw IllegalArgumentException("round must be gte 0")
        }
    }

    fun canStartNext() : Boolean = this.value > 0

    fun startNext() {
        this.decrease()
    }

    private fun decrease() {
        this.value--
    }
}