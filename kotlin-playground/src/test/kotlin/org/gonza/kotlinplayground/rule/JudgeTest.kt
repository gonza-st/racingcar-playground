package org.gonza.kotlinplayground.rule

import org.gonza.kotlinplayground.Fixture
import org.gonza.kotlinplayground.racer.Racers
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JudgeTest {
    val racer1 = Fixture.createRacer(
        name = "에이바겐",
        number = 1
    )

    val racer2 = Fixture.createRacer(
        name = "비바겐",
        number = 5
    )

    @Test
    fun `우승자를 계산할 수 있다`(){
        val turns = 5
        val racerList = listOf(racer1, racer2)

        val racers = Racers(racerList)

        racers.race(turns)

        val actual = Judge()
        val winner = actual.winner(racerList)

        assertEquals(winner, listOf(racer2))
    }

    @Test
    fun `우승자는 2명 이상일 수 있다`(){
        val racer3 = Fixture.createRacer(
            name = "씨바겐",
            number = 5
        )

        val racerList = listOf(racer1, racer2, racer3)
        val turns = 5

        val racers= Racers(racerList)

        racers.race(turns)

        val actual = Judge()
        val winner = actual.winner(racerList)

        assertEquals(winner, listOf(racer2, racer3))
    }

}