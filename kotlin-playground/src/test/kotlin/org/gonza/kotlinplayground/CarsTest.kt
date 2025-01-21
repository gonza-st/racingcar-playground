package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.racingCarPlayGround.Cars
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

class CarsTest {
    @Test
    @DisplayName("경주에 참여할 차가 1대 이상이어야 한다")
    fun emptyCarsTest() {
        val carNames = ""

        assertThrows<IllegalArgumentException> {
            Cars.fromString(carNames)
        }
    }

    @Test
    @DisplayName("차 이름 문자열로 Cars를 생성한다")
    fun createCarsTest() {
        val carNames = "bus,taxi,bike"

        val cars: Cars = Cars.fromString(carNames)

        assertTrue(cars.contains("bus"))
        assertTrue(cars.contains("taxi"))
        assertTrue(cars.contains("bike"))
        assertEquals(3, cars.size())
    }

    @Test
    @DisplayName("차 이름 문자열에 공백이 있다면 공백을 제거하여 Cars를 생성한다")
    fun createCarsWithSpacesTest() {
        val carNamesWithSpaces = " bus , t a x i , b   ike "

        val cars = Cars.fromString(carNamesWithSpaces)

        assertTrue(cars.contains("bus"))
        assertTrue(cars.contains("taxi"))
        assertTrue(cars.contains("bike"))
        assertEquals(3, cars.size())
    }

    @Test
    @DisplayName("차 이름 문자열에 쉼표 이후 빈 값은 제외하고 Cars를 생성한다")
    fun createCarsWithEmptyNameTest() {
        val carNamesWithEmpty = "bus,,taxi,,,bike,"

        val cars = Cars.fromString(carNamesWithEmpty)

        assertTrue(cars.contains("bus"))
        assertTrue(cars.contains("taxi"))
        assertTrue(cars.contains("bike"))
        assertEquals(3, cars.size())
    }
}
