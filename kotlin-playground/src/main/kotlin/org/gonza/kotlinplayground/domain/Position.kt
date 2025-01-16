package org.gonza.kotlinplayground.domain

class Position(
    val value: Int,
) {
    companion object {
        fun init(): Position = Position(0)
    }

    fun increase(): Position = Position(value + 1)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Position) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int = value

    override fun toString(): String = "Position(value=$value)"
}
