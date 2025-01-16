package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RaceTimesTest {
    @Test
    fun `경주 횟수를 차감한다`() {
        val raceTimes = RaceTimes(5)
        val decreasedRaceTimes = raceTimes.decrease()

        val expectedValue = RaceTimes(4)

        Assertions.assertThat(decreasedRaceTimes).isEqualTo(expectedValue)
    }

    @Test
    fun `경주 횟수가 0인지 확인한다`() {
        val raceTimes = RaceTimes(0)
        val result = raceTimes.isNotZero()

        val expectedValue = false

        Assertions.assertThat(result).isEqualTo(expectedValue)
    }

    @Test
    fun `경주 횟수가 음수라면 에러가 발생한다`() {
        Assertions
            .assertThatThrownBy {
                RaceTimes(-1)
            }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("경주 횟수는 0 이상이어야 합니다.")
    }
}
