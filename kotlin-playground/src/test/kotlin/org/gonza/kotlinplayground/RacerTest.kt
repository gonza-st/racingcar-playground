package org.gonza.kotlinplayground

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RacerTest {
    @Test
    fun `레이서는 차를 가질 수 있다`(){
        val car = Fixture.car
        val actual = Racer(
            car = car
        )

        assertEquals(car, actual.car)
    }
}