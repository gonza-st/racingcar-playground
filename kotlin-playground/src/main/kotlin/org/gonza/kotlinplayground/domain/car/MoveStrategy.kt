package org.gonza.kotlinplayground.domain.car

@FunctionalInterface
fun interface MoveStrategy {
    fun canMove(): Boolean
}