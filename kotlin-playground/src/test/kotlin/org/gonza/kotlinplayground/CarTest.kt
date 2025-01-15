package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.utils.TestNumberGenerator
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CarTest {

    private val validator = Validator()
    private val generator = TestNumberGenerator(5)

    @Test
    fun `자동차는 이름을 가질 수 있다`() {
        val validName = "봉고"
        val car = Car(name = validName, validator = validator, generator = generator)

        assertTrue { car.name.isNotBlank() }
    }

    @Test
    fun `자동차의 이름은 5자를 초과할 수 없다`() {
        val invalidName = "이것은_울트라_짱짱긴_자동차이름"

        assertThrows<IllegalArgumentException> { Car(name = invalidName, validator = validator, generator = generator) }
    }

    @Test
    fun `자동차는 본인이 움직인 거리를 가질 수 있다`() {
        val car = Car(name = "아반떼", validator = validator, generator = generator)
        val expectedDistance = 0

        assertEquals(expectedDistance, car.distance)
    }

    @Test
    fun `자동차가 움직일 경우 거리가 1씩 증가한다`() {
        val car = Car(name = "아반떼", validator = validator, generator = generator)
        val count = 100

        repeat(count) {
            car.move()
        }

        assertEquals(count, car.distance)
    }

    @Test
    fun `기준값 이상일 경우만 전진한다`() {
        val expectedDistance = 0
        val invalidGenerator = TestNumberGenerator(3)
        val car = Car(name = "벤스", validator = validator, generator = invalidGenerator)

        assertEquals(expectedDistance, car.distance)
    }
}