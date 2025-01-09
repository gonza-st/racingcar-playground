package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.RacingCars
import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException
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

    @Test
    fun `게임내의 경주하는 차량들은 이름이 중복되어서는 안된다`() {
        val duplicatedCar1 = Car("name", 1)
        val duplicatedCar2 = Car("name", 2)
        val car1 = Car("1", 1)
        val car2 = Car("2", 2)

        assertThatThrownBy {
            RacingCars(listOf(duplicatedCar1, duplicatedCar2))
        }.isInstanceOf(DuplicatedCarNameException::class.java)

        assertThat(RacingCars(listOf(car1, car2))).isNotNull()
    }
}