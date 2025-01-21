package org.gonza.kotlinplayground.racingCarPlayGround

class Cars private constructor(val carList: List<Car>) {
    companion object {
        fun fromString(carNames: String): Cars {
            require(carNames.isNotEmpty()) { "경주에 참여할 차가 최소 1대 이상이어야 한다" }

            val carNameList: List<String> = carNames.split(",").map { it.replace(" ", "") }.filter { it.isNotEmpty() }
            val carList: List<Car> = carNameList.map { name -> Car(name = name) }
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
        return carList.maxOf { it.position }
    }

    fun findWinners(maxPosition: Int): List<Car> {
        return carList.filter { it.position == maxPosition }
    }

    fun size(): Int {
        return carList.size
    }

    fun contains(name: String): Boolean {
        return carList.any { it.name == name }
    }

    fun printCars() {
        carList.forEach { car -> car.printCar() }
        println()
    }
}