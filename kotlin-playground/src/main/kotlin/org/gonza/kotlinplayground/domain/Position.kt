package org.gonza.kotlinplayground.domain

data class Position(
    val value: Int,
) {
    init {
        require(value >= 0) { "Position은 0 이상이어야 합니다" }
    }

    companion object {
        fun init(): Position = Position(0)
    }

    fun increase(): Position = Position(value + 1)
}
