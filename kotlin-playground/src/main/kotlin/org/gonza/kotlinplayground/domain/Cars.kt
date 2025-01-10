package org.gonza.kotlinplayground.domain

class Cars(private val cars: List<Car>) {
    var tryCount: Int = 0
    private set

    fun size() = cars.size

    fun moveAll(count: Int) {
        while (tryCount < count) {
            increaseCount()
            cars.all { it.move() }
        }
    }

    private fun increaseCount() = tryCount++
}