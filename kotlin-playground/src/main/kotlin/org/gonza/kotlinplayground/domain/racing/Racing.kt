package org.gonza.kotlinplayground.domain.racing

import org.gonza.kotlinplayground.domain.car.Car

class Racing(
    carsName: String
) {
    val carList: List<Car> = createCarList(carsName = carsName)

    private fun createCarList(carsName: String): List<Car> {
        val nameList = carsName.split(",")
        val carList = nameList.map { Car(it) }
        return carList
    }
}