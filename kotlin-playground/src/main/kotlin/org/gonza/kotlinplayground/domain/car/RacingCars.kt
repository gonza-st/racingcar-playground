package org.gonza.kotlinplayground.domain.car

import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException

class RacingCars(
    private val carList: List<Car>,
) {
    init {
        validateDuplicatedCarName()
    }

    fun findFarthestCarList(): List<Car> {
        val farthestPosition = carList.maxOf { it.position }
        val farthestCarList = carList.filter { it.position == farthestPosition }

        return farthestCarList.getCarList()
    }

    fun move(moveStrategy: MoveStrategy): List<Car> {
        val movedCarList = carList.map { moveCar(it, moveStrategy) }
        return movedCarList.getCarList()
    }

    private fun moveCar(
        car: Car,
        strategy: MoveStrategy,
    ): Car {
        if (!strategy.canMove()) return car

        return car.move()
    }

    private fun validateDuplicatedCarName() {
        val distinctCarList = carList.distinctBy { it.name }

        if (carList.size != distinctCarList.size) {
            throw DuplicatedCarNameException()
        }
    }

    private fun List<Car>.getCarList() = this.map { Car(it.name, it.position) }
}
