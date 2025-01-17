package org.gonza.kotlinplayground.domain.car

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException
import org.junit.jupiter.api.Test

class RacingCarsTest {
    @Test
    fun `우승한 차량을 조회할 수 있다`() {
        val car1 = Car("1", 1)
        val car2 = Car("2", 2)
        val winner = Car("3", 3)
        val racingCars = RacingCars(listOf(car1, car2, winner))

        val carList = racingCars.findWinnerCarList()

        assertThat(carList).hasSize(1)
        assertThat(carList[0].getPosition()).isEqualTo(winner.getPosition())
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

    @Test
    fun `게임에 참가한 차량은 전략에 따라 차량을 움직일 수 없다`() {
        val testStrategy: MoveStrategy = MoveStrategy { false }
        val initPosition = 1
        val car1 = Car("1", initPosition)
        val car2 = Car("2", initPosition)
        val car3 = Car("3", initPosition)
        val racingCars = RacingCars(listOf(car1, car2, car3))

        val movedCarList = racingCars.move(testStrategy)

        assertThat(movedCarList[0].getPosition()).isEqualTo(initPosition)
        assertThat(movedCarList[1].getPosition()).isEqualTo(initPosition)
        assertThat(movedCarList[2].getPosition()).isEqualTo(initPosition)
    }

    @Test
    fun `게임에 참가한 차량은 전략에 따라 차량을 움직일 수 있다`() {
        val testStrategy: MoveStrategy = MoveStrategy { true }
        val initPosition = 1
        val car1 = Car("1", initPosition)
        val car2 = Car("2", initPosition)
        val car3 = Car("3", initPosition)
        val racingCars = RacingCars(listOf(car1, car2, car3))

        val movedCarList = racingCars.move(testStrategy)

        assertThat(movedCarList[0].getPosition()).isNotEqualTo(initPosition)
        assertThat(movedCarList[1].getPosition()).isNotEqualTo(initPosition)
        assertThat(movedCarList[2].getPosition()).isNotEqualTo(initPosition)
    }
}
