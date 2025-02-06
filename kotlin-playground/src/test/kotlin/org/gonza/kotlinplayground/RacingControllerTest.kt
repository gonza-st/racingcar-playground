package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.racingCarPlayGround.Car
import org.gonza.kotlinplayground.racingCarPlayGround.Cars
import org.gonza.kotlinplayground.racingCarPlayGround.RacingController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse

class RacingControllerTest {
    companion object {
        private const val MOVABLE_STANDARD = 4
    }

    @Test
    @DisplayName("시도할 횟수는 1회 이상이어야 한다")
    fun emptyRoundTest() {
        val zeroRound: Int = 0
        val cars = Cars.fromString("taxi")

        assertThrows<IllegalArgumentException> {
            RacingController(cars = cars, round = zeroRound)
        }
    }

    @Test
    @DisplayName("레이스 랜덤 값을 구한다")
    fun getRandomTest() {
        val round: Int = 1
        val cars = Cars.fromString("taxi")

        val racing = RacingController(cars = cars, round = round)
        val randomNumber = racing.getRandom()

        assertTrue(randomNumber in 0..9)
    }

    @Test
    @DisplayName("랜덤 값이 전진 가능한 기준값 이상인지 판단한다")
    fun canMoveTest() {
        val round: Int = 1

        val cars = Cars.fromString("taxi")
        val racing = RacingController(cars = cars, round = round)

        assertTrue(racing.canMove(MOVABLE_STANDARD))
        assertTrue(racing.canMove(MOVABLE_STANDARD + 1))
        assertFalse(racing.canMove(MOVABLE_STANDARD - 1))
    }

    @Test
    @DisplayName("가장 멀리 이동한 차가 우승자이다")
    fun findWinnerTest() {
        val bus = Car.create(name = "bus", position = 1)
        val taxi = Car.create(name = "taxi", position = 2)
        val bike = Car.create(name = "bike", position = 3)

        val racing = RacingController(cars = Cars.fromList(listOf(bus, taxi, bike)), round = 1)
        val winners = racing.findWinners()

        assertEquals(1, winners.size)
        assertTrue(winners.contains(bike))
    }

    @Test
    @DisplayName("우승자는 한 명 이상일 수 있다")
    fun findMultipleWinnersTest() {
        val bus = Car.create(name = "bus", position = 1)
        val taxi = Car.create(name = "taxi", position = 2)
        val bike = Car.create(name = "bike", position = 2)

        val racing = RacingController(cars = Cars.fromList(listOf(bus, taxi, bike)), round = 3)

        val winners = racing.findWinners()

        assertEquals(2, winners.size)
        assertTrue(winners.contains(taxi))
        assertTrue(winners.contains(bike))
    }
}