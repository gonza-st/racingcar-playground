package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.domain.Cars
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CarsTest {
    @Test
    fun `자동차 객체들을 가질 수 있다`() {
        val validator = Validator()
        val car1 = Car(name = "아반따", validator = validator)
        val car2 = Car(name = "폴쉐", validator = validator)
        val car3 = Car(name = "벤스", validator = validator)
        val carList = listOf(car1, car2, car3)
        val cars = Cars(carList)

        assertEquals(carList.size, cars.size())
    }

    @Test
    fun `입력된 횟수만큼 이동을 반복한다`() {
        val validator = Validator()
        val count = 5
        val car1 = Car(name = "아반따", validator = validator)
        val car2 = Car(name = "폴쉐", validator = validator)
        val car3 = Car(name = "벤스", validator = validator)
        val carList = listOf(car1, car2, car3)
        val cars = Cars(carList)

        cars.moveAll(count)

        assertEquals(count, cars.tryCount)
    }
}