package org.gonza.kotlinplayground.domain

class CarName {
    constructor(value: String) {
        if(isOverFive(value)) {
            throw Exception("name must be lte 5")
        }

        this.value = value
    }

    val value: String

    private fun isOverFive(value: String): Boolean = value.length > 5
}