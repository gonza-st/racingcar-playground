package org.gonza.kotlinplayground.domain

class RacingCars(
    private val carList: List<Car>
) {
    fun findWonCarList(): List<Car> {
        val farthestPosition = carList.maxOf { it.getPosition() }
        val farthestCarList = carList.filter { it.getPosition() == farthestPosition }

        return farthestCarList.map {
            Car(it.getName(), it.getPosition())
        }
    }
}