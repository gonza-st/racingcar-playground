package org.gonza.kotlinplayground.domain.racing

class Round(
    val value: Int
) {
    init {
        if(value < 0) {
            throw IllegalArgumentException("round must be gte 0")
        }
    }
}