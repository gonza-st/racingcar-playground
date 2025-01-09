package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CarTest {
    @Test
    fun `자동차는 이름을 가질 수 있다`() {
        val validName = "봉고"
        val validator = Validator()
        val car = Car(name = validName, validator = validator)

        assertTrue { car.name.isNotBlank() }
    }

    @Test
    fun `자동차의 이름은 5자를 초과할 수 없다`() {
        val invalidName = "이것은_울트라_짱짱긴_자동차이름"
        val validator = Validator()

        assertThrows<IllegalArgumentException> { Car(name = invalidName, validator = validator) }
    }

    @Test
    fun `자동차는 본인이 움직인 거리를 가질 수 있다`() {
        val validator = Validator()
        val car = Car(name = "아반떼", validator = validator)
        val expectedDistance = 0

        assertEquals(expectedDistance, car.distance)
    }

    @Test
    fun `자동차가 움직일 경우 거리가 1씩 증가한다`() {
        val validator = Validator()
        val car = Car(name = "아반떼", validator = validator)
        val count = 100

        repeat(count) {
            car.move()
        }

        assertEquals(count, car.distance)
    }

    @Test
    fun `기준값 이상일 경우만 전진한다`() {
        val randomNumberList = listOf(4, 5, 6, 7, 1)
        val expectedDistance = randomNumberList.count { it >= RacingConstants.RANDOM_NUMBER_THRESHOLD }
        val validator = Validator()
        val car = Car(name = "벤스", validator = validator)

        randomNumberList.forEach { number ->
            val isMoveable = validator.isNumberGreaterThanThreshold(
                target = number,
                threshold = RacingConstants.RANDOM_NUMBER_THRESHOLD
            )

            if (isMoveable) {
                car.move()
            }
        }

        assertEquals(expectedDistance, car.distance)
    }
}