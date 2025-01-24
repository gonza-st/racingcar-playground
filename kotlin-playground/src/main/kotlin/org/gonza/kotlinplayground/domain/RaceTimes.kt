package org.gonza.kotlinplayground.domain

data class RaceTimes(
    private val value: Int,
) {
    init {
        if (value < 0) {
            throw IllegalArgumentException("경주 횟수는 0 이상이어야 합니다.")
        }
    }

    fun decrease(): RaceTimes = RaceTimes(this.value - 1)

    fun isNotZero(): Boolean = this.value > 0
}
