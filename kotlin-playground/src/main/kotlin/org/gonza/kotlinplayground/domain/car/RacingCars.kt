package org.gonza.kotlinplayground.domain.car

import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException

class RacingCars(
    private val carList: List<Car>
) {

    init {
        validateDuplicatedCarName()
    }

    fun findWonCarList(): List<Car> {
        val farthestPosition = carList.maxOf { it.getPosition() }
        val farthestCarList = carList.filter { it.getPosition() == farthestPosition }

        return farthestCarList.map {
            Car(it.getName(), it.getPosition())
        }
    }

    private fun validateDuplicatedCarName() {
        val distinctCarList = carList.distinctBy { it.getName() }

        if (carList.size != distinctCarList.size) {
            throw DuplicatedCarNameException()
        }
    }
}