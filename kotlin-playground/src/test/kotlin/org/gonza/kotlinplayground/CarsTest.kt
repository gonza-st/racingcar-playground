package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.domain.Cars
import org.gonza.kotlinplayground.utils.TestNumberGenerator
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CarsTest {

    private val validator = Validator()
    private val generator = TestNumberGenerator(5)
    @Test
    fun `자동차 객체들을 가질 수 있다`() {
        val car1 = Car(name = "아반따", validator = validator, generator = generator)
        val car2 = Car(name = "폴쉐", validator = validator, generator = generator)
        val car3 = Car(name = "벤스", validator = validator, generator = generator)
        val carList = listOf(car1, car2, car3)
        val cars = Cars(carList)

        assertEquals(carList, cars.getCarList())
    }

    @Test
    fun `이동한 거리가 가장 큰 자동차를 반환한다`() {
        val invalidGenerator = TestNumberGenerator(3)
        val validGenerator = TestNumberGenerator(9)
        val car1 = Car(name = "아반따", validator = validator, generator = invalidGenerator)
        val car2 = Car(name = "폴쉐", validator = validator, generator = validGenerator)
        val car3 = Car(name = "벤스", validator = validator, generator = validGenerator)
        val carList = listOf(car1, car2, car3)
        val expectedCarList = listOf(car2, car3)
        val cars = Cars(carList)
        val count = 10

        repeat(count) {
            cars.moveAll()
        }

        assertEquals(expectedCarList, cars.findWinner())
    }
}