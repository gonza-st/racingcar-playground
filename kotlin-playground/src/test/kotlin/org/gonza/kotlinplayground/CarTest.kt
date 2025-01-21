package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.racingCarPlayGround.Car
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    @DisplayName("차 이름이 빈 문자열이면 에러가 발생한다")
    fun emptyCarNameTest() {
        assertThrows<IllegalArgumentException> {
            Car(name = "", position = 0)
        }
    }

    @Test
    @DisplayName("차 이름에 공백만 있으면 에러가 발생한다")
    fun onlySpacesInNameTest() {
        assertThrows<IllegalArgumentException> {
            Car(name = "   ", position = 0)
        }
    }

    @Test
    @DisplayName("차 이름이 5자를 초과하면 에러가 발생한다")
    fun nameLengthTest() {
        val maxLength = 5
        val carNameExceedingMaxLength = "A".repeat(maxLength + 1)

        assertThrows<IllegalArgumentException> {
            Car(name = carNameExceedingMaxLength, position = 0)
        }
    }

    @Test
    @DisplayName("차 위치는 0 이상이어야 한다")
    fun zeroPositionTest() {
        assertThrows<IllegalArgumentException> {
            Car(name = "car", position = -1)
        }
    }

    @Test
    @DisplayName("차가 전진한다")
    fun movePositionTest() {
        val car = Car(name = "car", position = 0)
        val movedCar = car.move()

        assertEquals(Car.MOVING_POSITION, movedCar.position)
    }
}