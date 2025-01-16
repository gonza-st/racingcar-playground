package org.gonza.kotlinplayground

class RaceTimes(
    private val value: Int,
) {
    init {
        if (value < 0) {
            throw IllegalArgumentException("경주 횟수는 0 이상이어야 합니다.")
        }
    }

    fun decrease(): RaceTimes = RaceTimes(this.value - 1)

    fun equal(other: Int): Boolean = this.value == other

    fun isNotZero(): Boolean = this.value > 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RaceTimes) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int = value
}
