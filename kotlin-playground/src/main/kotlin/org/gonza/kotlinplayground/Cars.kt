package org.gonza.kotlinplayground

private const val POSITION_DELIMITER = "-"
private const val NAME_DELIMITER = ", "

class Cars(
    private val carList: List<Car>,
) {
    fun positions(): String {
        val positions =
            this.carList
                .joinToString("\n") { "${it.name} : ${POSITION_DELIMITER.repeat(it.position())}" }
        return positions
    }

    fun winners(): String {
        val maxPosition = this.carList.maxOf { it.position() }
        val winners = this.carList.filter { it.positionEqual(maxPosition) }
        return winners.joinToString(NAME_DELIMITER) { it.name }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cars) return false

        if (carList != other.carList) return false

        return true
    }

    override fun hashCode(): Int = carList.hashCode()

    override fun toString(): String = "Cars(carList=$carList)"
}
