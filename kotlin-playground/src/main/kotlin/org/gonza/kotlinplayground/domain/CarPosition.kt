package org.gonza.kotlinplayground.domain;

class CarPosition(
    var value: Int = 0
) {
    fun move() {
        this.value++
    }
}