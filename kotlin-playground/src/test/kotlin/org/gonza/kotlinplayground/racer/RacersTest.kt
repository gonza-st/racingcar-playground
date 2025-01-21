package org.gonza.kotlinplayground.racer

import org.gonza.kotlinplayground.Fixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class RacersTest {
    val racer1 = Fixture.createRacer(
        name = "에이바겐",
        number = 1
    )

    val racer2 = Fixture.createRacer(
        name = "비바겐",
        number = 5
    )

    @Test
    fun `Racer를 일급 컬렉션으로 관리할 수 있다`(){
        assertDoesNotThrow {
            Racers(listOf( racer1, racer2))
        }
    }

    @Test
    fun `Racers 에서 Racer가 없을 수 없다`(){
        assertThrows<IllegalArgumentException> {
            Racers(emptyList())
        }
    }

    @Test
    fun `Racers로 게임을 진행할 수 있다`(){
        val turns = 5

        val actual = Racers(
            listOf(racer1, racer2)
        )

        actual.play(turns)

        assertEquals(racer1.car.location, 0 )
        assertEquals(racer2.car.location, 5 )
    }

    @Test
    fun `turns은 음수 일 수 없다`(){
        val turns = -1

        val actual = Racers(
            listOf(racer1, racer2)
        )

        assertThrows<IllegalArgumentException> {
            actual.play(turns)
        }
    }

}