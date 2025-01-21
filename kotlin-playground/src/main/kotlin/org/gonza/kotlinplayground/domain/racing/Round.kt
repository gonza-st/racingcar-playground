package org.gonza.kotlinplayground.domain.racing

class Round(
    var value: Int
) {
    init {
        if(value < 0) {
            throw IllegalArgumentException("round must be gte 0")
        }
    }

    fun startNext(): Boolean {
        this.decrease()
        return this.value >= 0
    }

    private fun decrease() {
        this.value--
    }
}