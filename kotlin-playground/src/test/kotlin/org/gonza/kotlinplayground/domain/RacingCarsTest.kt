package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingCarsTest {
    @Test
    fun `우승한 차량을 조회할 수 있다`() {
        val car1 = Car("1", 1)
        val car2 = Car("2", 2)
        val wonCar = Car("3", 3)
        val racingCars = RacingCars(listOf(car1, car2, wonCar))

        val carList = racingCars.findWonCarList()

        assertThat(carList).hasSize(1)
        assertThat(carList[0].getPosition()).isEqualTo(wonCar.getPosition())
    }
}