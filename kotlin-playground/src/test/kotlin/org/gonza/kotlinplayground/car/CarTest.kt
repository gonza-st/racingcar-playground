package org.gonza.kotlinplayground.car

import org.gonza.kotlinplayground.Fixture
import org.gonza.kotlinplayground.car.Car
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가질 수 있다`(){
        val actual = Car(
            name = Fixture.name,
        )

        assert(actual.name == "지바겐")
        assert(actual.location == 0)
    }

    @Test
    fun `자동차의 이름은 비어있을 수 없다`(){
        assertThrows<IllegalArgumentException> {
            Car(name = "")
        }
    }

    @Test
    fun `자동차의 처음 위치는 0 일 수 있다`(){
        val actual = Car(Fixture.name)

        assertEquals(actual.location , Fixture.location)
    }

    @Test
    fun `자동차는 움직일 수 있다`(){
        val actual = Car(Fixture.name)

        actual.move()

        assertEquals(actual.location, 1)
    }
}