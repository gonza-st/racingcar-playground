package org.gonza.kotlinplayground

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가질 수 있다`(){
        val actual = Car(
            name = Fixture.name,
            location = Fixture.location
        )

        assert(actual.name == "지바겐")
        assert(actual.location == 0)
    }

    @Test
    fun `자동차의 이름은 비어있을 수 없다`(){
        assertThrows<IllegalArgumentException> {
            Car(name = "", location = 0)
        }
    }

    @Test
    fun `자동차의 위치는 음수일 수 없다`(){
        assertThrows<IllegalArgumentException> {
            Car(
                name = Fixture.name,
                location = -1
            )
        }
    }
}