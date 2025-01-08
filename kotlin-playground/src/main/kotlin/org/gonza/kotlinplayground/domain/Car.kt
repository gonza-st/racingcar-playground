package org.gonza.kotlinplayground.domain

class Car(
    private val position: Int
) {
    fun move(): Car {
        return Car(position + 1)
    }

    fun getPosition(): Int {
        return position
    }
}