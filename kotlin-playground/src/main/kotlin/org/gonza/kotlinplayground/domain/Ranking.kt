package org.gonza.kotlinplayground.domain

class Ranking {
    fun rank(carList: List<Car>): List<String> {
        val movement = carList.map { car -> "${car.name} : ${"-".repeat(car.distance)}" }
        return movement
    }
}