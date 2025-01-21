package org.gonza.kotlinplayground.domain

data class Position(
    val value: Int,
) {
    companion object {
        fun init(): Position = Position(0)
    }

    fun increase(): Position = Position(value + 1)
}
