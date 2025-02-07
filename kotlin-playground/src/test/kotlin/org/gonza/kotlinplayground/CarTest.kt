package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.racingCarPlayGround.Car
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

class CarTest {
    companion object {
        private const val MAX_NAME_LENGTH = 5
    }

    @Test
    @DisplayName("차 이름이 빈 문자열이면 에러가 발생한다")
    fun emptyCarNameTest() {
        assertThrows<IllegalArgumentException> {
            Car.create(name = "", position = 0)
        }
    }

    @Test
    @DisplayName("차 이름에 공백만 있으면 에러가 발생한다")
    fun onlySpacesInNameTest() {
        assertThrows<IllegalArgumentException> {
            Car.create(name = "   ", position = 0)
        }
    }

    @Test
    @DisplayName("차 이름이 5자를 초과하면 에러가 발생한다")
    fun nameLengthTest() {
        val carNameExceedingMaxLength = "A".repeat(MAX_NAME_LENGTH + 1)

        assertThrows<IllegalArgumentException> {
            Car.create(name = carNameExceedingMaxLength, position = 0)
        }
    }

    @Test
    @DisplayName("차 이름 길이가 정상 범위면 객체가 생성된다")
    fun validNameTest() {
        assertDoesNotThrow { Car.create(name = "A", position = 0) }
        assertDoesNotThrow { Car.create(name = "A".repeat(MAX_NAME_LENGTH), position = 0) }
        assertDoesNotThrow { Car.create(name = "Car1", position = 0) }
    }

    @Test
    @DisplayName("차 위치는 0 이상이어야 한다")
    fun zeroPositionTest() {
        assertThrows<IllegalArgumentException> {
            Car.create(name = "car", position = -1)
        }
    }

    @Test
    @DisplayName("차가 전진한다")
    fun movePositionTest() {
        val car = Car.create(name = "car", position = 0)
        val movedCar = car.move()

        val expectedCar = Car.create("car", Car.MOVING_POSITION)
        assertTrue(
                movedCar.isSamePosition(Car.MOVING_POSITION),
                "전진 후 위치가 예상 위치와 다릅니다"
        )
    }
}