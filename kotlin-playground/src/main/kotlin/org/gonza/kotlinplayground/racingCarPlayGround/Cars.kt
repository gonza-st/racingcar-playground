package org.gonza.kotlinplayground.racingCarPlayGround

class Cars private constructor(val carList: List<Car>) {
    companion object {
        fun fromString(carNames: String): Cars {
            require(carNames.isNotEmpty()) { "경주에 참여할 차가 최소 1대 이상이어야 한다" }

            val carNameList: List<String> = carNames.split(",").map { it.replace(" ", "") }.filter { it.isNotEmpty() }
            val carList: List<Car> = carNameList.map { name -> Car.create(name = name) }
            return Cars(carList)
        }

        fun fromList(cars: List<Car>): Cars {
            require(cars.isNotEmpty()) { "경주에 참여할 차가 최소 1대 이상이어야 한다" }
            return Cars(cars)
        }
    }

    fun isNotEmpty(): Boolean {
        return carList.isNotEmpty()
    }

    fun getMaxPosition(): Int {
        return carList.maxOf { car1 ->
            carList.fold(0) { maxPos, car2 ->
                if (car2.comparePositionWith(car1) > 0) car2.comparePositionWith(car1) else maxPos
            }
        }
    }

    fun findWinners(maxPosition: Int): List<Car> {
        return carList.filter { it.isSamePosition(maxPosition) }
    }

    fun size(): Int {
        return carList.size
    }

    fun contains(name: String): Boolean {
        return carList.any { it.isSameName(name) }
    }

    fun printCars() {
        val printer = Printer()
        carList.forEach { car -> printer.printCar(car) }
        println()
    }
}