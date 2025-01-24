package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions
import org.gonza.kotlinplayground.fixture.TestFixture
import org.junit.jupiter.api.Test

class HistoryTest {
    @Test
    fun `자동차들의 위치 정보를 반환한다`() {
        val numberGenerator: NumberGenerator = TestFixture.getMovedNumberGenerator()
        val carList: List<Car> =
            listOf(
                Car("pobi", numberGenerator),
                Car("crong", numberGenerator),
                Car("honux", numberGenerator),
                Car("jk", numberGenerator),
            )
        carList.forEach { it.move() }
        val history: History = History(carList)
        val positions: String = history.positions()

        val expectedValue =
            """
            pobi : -
            crong : -
            honux : -
            jk : -
            """.trimIndent()

        Assertions.assertThat(positions).isEqualTo(expectedValue)
    }

    @Test
    fun `현재 자동차들 중에 가장 멀리 간 자동차들의 이름을 반환한다`() {
        val numberGenerator: NumberGenerator = TestFixture.getMovedNumberGenerator()
        val carList: List<Car> =
            listOf(
                Car("pobi", numberGenerator),
                Car("crong", numberGenerator),
                Car("honux", numberGenerator),
                Car("jk", numberGenerator),
            )
        carList.forEach { it.move() }
        val history: History = History(carList)
        val winners: String = history.winners()

        val expectedValue = "pobi, crong, honux, jk"

        Assertions.assertThat(winners).isEqualTo(expectedValue)
    }
}
