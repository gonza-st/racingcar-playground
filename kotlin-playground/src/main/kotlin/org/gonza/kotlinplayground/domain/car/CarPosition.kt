package org.gonza.kotlinplayground.domain.car;

class CarPosition(
    var value: Int = 0
) {
    fun move() {
        this.value++
    }
}