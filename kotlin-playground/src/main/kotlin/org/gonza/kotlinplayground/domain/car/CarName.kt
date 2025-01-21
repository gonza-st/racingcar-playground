package org.gonza.kotlinplayground.domain.car

class CarName(
    val value: String
) {
    init {
        if(isOverFive(value)) {
            throw IllegalArgumentException("name must be lte 5")
        }
    }

    private fun isOverFive(value: String): Boolean = value.length > 5
}