package org.gonza.kotlinplayground.domain

private const val POSITION_DELIMITER = "-"
private const val NAME_DELIMITER = ", "

data class Cars(
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
}
