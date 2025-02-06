package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Rap
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RapTest {
    @Test
    fun `랩 수가 증가한다`() {
        val rap = Rap(round = 5)
        val expectedRap = 5

        repeat(rap.getRound()) {
            rap.increaseRound()
        }

        assertEquals(expectedRap, rap.getCurrentRap())
    }

    @Test
    fun `랩 수가 감소한다`() {
        val rap = Rap(round = 5)
        val expectedRap = 0

        repeat(rap.getRound()) {
            rap.increaseRound()
        }

        repeat(rap.getRound()) {
            rap.decreaseRound()
        }

        assertEquals(expectedRap, rap.getCurrentRap())
    }
}