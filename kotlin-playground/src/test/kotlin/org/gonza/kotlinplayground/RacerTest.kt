package org.gonza.kotlinplayground

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertEquals

class RacerTest {
    val car = Fixture.car
    val accelerate = getAccelerate(2)

    @Test
    fun `레이서는 차와 엑셀을 가질 수 있다`(){
        assertDoesNotThrow {
            Racer(
                car = car,
                accelerate = accelerate
            )
        }
    }

    @Test
    fun `레이서의 첫 위치는 0일 수 있다`(){
        val actual = Racer(
            car = car,
            accelerate = accelerate
        )

        assertEquals(actual.car.location, 0)
    }

    @Test
    fun `레이서는 엑셀을 밟아 움직일 수 있다`(){
        val accelerate = getAccelerate(5)
        val actual = Racer(
            car = car,
            accelerate = accelerate
        )

        actual.race()

        assertEquals(actual.car.location, 1)
    }

    @Test
    fun `레이서는 브레이크를 밟고 정지할 수 있다`(){
        val accelerate = getAccelerate(0)
        val actual = Racer(
            car = car,
            accelerate = accelerate
        )

        actual.race()

        assertEquals(actual.car.location, 0)
    }

    private fun getAccelerate(number: Int): Accelerate{
        return  Accelerate(
            numberGenerator = FakeNumberGeneratorImpl(number)
        )
    }
}