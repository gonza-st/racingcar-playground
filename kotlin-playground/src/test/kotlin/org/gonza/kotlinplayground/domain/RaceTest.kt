package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions
import org.gonza.kotlinplayground.fixture.MovedNumberGenerator
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `한번 진행시키면 현재 상태 값을 가진 차들을 반환한다`() {
        val numberGenerator = MovedNumberGenerator()
        val race =
            Race(
                carNameString = "아반떼, 소나타, 그랜저",
                raceTimes = 1,
                numberGenerator = numberGenerator,
            )

        val carList = race.proceedRound()
        for (car in carList) {
            println(car)
        }

        val expectedCarList =
            listOf(
                Car("아반떼", Position(1), numberGenerator),
                Car("소나타", Position(1), numberGenerator),
                Car("그랜저", Position(1), numberGenerator),
            )

        Assertions.assertThat(carList).isEqualTo(expectedCarList)
    }

    @Test
    fun `경주가 전체 진행되면 raceTimes는 0이 된다`() {
        val numberGenerator = MovedNumberGenerator()
        val race =
            Race(
                carNameString = "아반떼, 소나타, 그랜저",
                raceTimes = 5,
                numberGenerator = numberGenerator,
            )
        race.run()

        val expectedValue = 0

        Assertions.assertThat(race.timesEqualTo(expectedValue)).isEqualTo(true)
    }

    @Test
    fun `경주가 진행되면 raceResult에 결과값들이 쌓인다`() {
        val numberGenerator = MovedNumberGenerator()
        val race =
            Race(
                carNameString = "아반떼, 소나타, 그랜저",
                raceTimes = 3,
                numberGenerator = numberGenerator,
            )
        race.run()

        val expectedValue =
            listOf(
                """
                아반떼 : -
                소나타 : -
                그랜저 : -
                """.trimIndent(),
                """
                아반떼 : --
                소나타 : --
                그랜저 : --
                """.trimIndent(),
                """
                아반떼 : ---
                소나타 : ---
                그랜저 : ---
                """.trimIndent(),
            )

        Assertions.assertThat(race.raceResult).isEqualTo(expectedValue)
    }

    @Test
    fun `우승자를 알 수 있다`() {
        val numberGenerator = MovedNumberGenerator()
        val race =
            Race(
                carNameString = "아반떼, 소나타, 그랜저",
                raceTimes = 3,
                numberGenerator = numberGenerator,
            )
        race.run()

        val expectedValue = "아반떼, 소나타, 그랜저"

        Assertions.assertThat(race.raceWinners).isEqualTo(expectedValue)
    }
}
