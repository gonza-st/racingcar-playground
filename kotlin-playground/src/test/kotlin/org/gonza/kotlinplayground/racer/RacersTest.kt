package org.gonza.kotlinplayground.racer

import org.gonza.kotlinplayground.Fixture.racer1
import org.gonza.kotlinplayground.Fixture.racer2
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class RacersTest {
    @Test
    fun `Racer를 일급 컬렉션으로 관리할 수 있다`(){
        assertDoesNotThrow {
            Racers(listOf(racer1, racer2))
        }
    }

    @Test
    fun `Racers 에서 Racer가 없을 수 없다`(){
        assertThrows<IllegalArgumentException> {
            Racers(emptyList())
        }
    }
    @Test
    fun `Racers 에 포함된 racer들을 조회할 수 있다`(){
        val racers = Racers(
            listOf(racer1, racer2)
        )

        val actual = racers.getRacers()
        assertEquals(actual[0], racer1)
        assertEquals(actual[1], racer2)
    }
}