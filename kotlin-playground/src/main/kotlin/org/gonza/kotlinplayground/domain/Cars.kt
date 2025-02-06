package org.gonza.kotlinplayground.domain

class Cars(private val cars: List<Car>) {
    fun getCarList() = cars

    fun size() = cars.size

    fun moveAll(): List<Car> {
        cars.forEach { it.move() }
        return cars
    }

    fun findWinner(): List<Car> {
        val groupedByDistance = cars.groupBy { it.distance }
        val winner = groupedByDistance.maxBy { it.key }.value

        return winner
    }
}