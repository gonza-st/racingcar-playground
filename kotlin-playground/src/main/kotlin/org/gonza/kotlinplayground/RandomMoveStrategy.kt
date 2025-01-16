package org.gonza.kotlinplayground

class RandomMoveStrategy : MoveStrategy {
    override fun determineNextMove(): Int {
        val random = (0..9).random()
        if (random >= 4) {
            return 1
        }
        return 0
    }
}
