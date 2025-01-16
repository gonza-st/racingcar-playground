package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.domain.Cars
import org.gonza.kotlinplayground.domain.Ranking
import org.gonza.kotlinplayground.domain.Track
import org.gonza.kotlinplayground.utils.TestNumberGenerator
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TrackTest {

    private val validator = Validator()
    private val generator = TestNumberGenerator(5)

    @Test
    fun `트랙은 랩 수를 가질 수 있다`() {
        val rap = 5
        val track = Track(rap = rap)

        assertEquals(rap, track.rap)
    }

    @Test
    fun `트랙에는 경주할 자동차가 존재한다`() {
        val car1 = Car(name = "아반따", validator = validator, generator = generator)
        val car2 = Car(name = "폴쉐", validator = validator, generator = generator)
        val car3 = Car(name = "벤스", validator = validator, generator = generator)
        val carList = listOf(car1, car2, car3)
        val cars = Cars(carList)
        val rap = 5
        val track = Track(rap = rap)
        val ranking = Ranking()

        val entryCount = track.setup(cars = cars, ranking = ranking)

        assertEquals(carList.size, entryCount)
    }

    @Test
    fun `트랙을 초기화 하지 않으면 예외가 발생한다`() {
        val rap = 5
        val track = Track(rap = rap)

        assertThrows<IllegalArgumentException> { track.start() }
    }

    @Test
    fun `Rap 만큼 경주를 반복한다`() {
        val car1 = Car(name = "아반따", validator = validator, generator = generator)
        val car2 = Car(name = "폴쉐", validator = validator, generator = generator)
        val car3 = Car(name = "벤스", validator = validator, generator = generator)
        val carList = listOf(car1, car2, car3)
        val cars = Cars(carList)
        val rap = 5
        val track = Track(rap = rap)
        val ranking = Ranking()

        track.setup(cars = cars, ranking = ranking)
        val result = track.start()

        assertEquals(rap, result.size)
    }
}