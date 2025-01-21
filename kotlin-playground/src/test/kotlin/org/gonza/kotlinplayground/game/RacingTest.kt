package org.gonza.kotlinplayground.game

import org.gonza.kotlinplayground.Fixture.racer1
import org.gonza.kotlinplayground.Fixture.racer2
import org.gonza.kotlinplayground.racer.Racers
import org.gonza.kotlinplayground.rule.Judge
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class RacingTest {
    val judge = Judge()
    @Test
    fun `Racers로 게임을 진행할 수 있다`(){
        val turns = 5
        val racers= Racers(
            listOf(racer1, racer2)
        )

        racers.race(turns)

        assertDoesNotThrow {
            Racing(
                racers,
                judge
            )
        }
    }
}