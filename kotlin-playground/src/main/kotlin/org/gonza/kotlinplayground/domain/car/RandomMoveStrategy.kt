package org.gonza.kotlinplayground.domain.car

class RandomMoveStrategy : MoveStrategy {
    private val passedValue = 4

    override fun canMove(): Boolean {
        val value = (1..9).random()
        return value >= passedValue
    }
}