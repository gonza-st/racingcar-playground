package org.gonza.kotlinplayground.domain.racing

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundTest {
    val round = 5
    @Test
    fun `라운드는 입력받은 값을 가진다`() {
        val result = Round(round)
        Assertions.assertThat(result.value).isEqualTo(round)
    }

    @Test
    fun `라운드는 0보다 작을 수 없다`() {
        val round = -1
        assertThrows<IllegalArgumentException> { Round(round) }
    }

    @Test
    fun `라운드가 0보다 클 경우 다음 라운드를 진행할 수 있다`() {
        val roundNumber = 1
        val round = Round(roundNumber)

        val result = round.canStartNext()
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `라운드가 0과 같을 경우 다음 라운드를 진행할 수 없다`() {
        val roundNumber = 0
        val round = Round(roundNumber)

        val result = round.canStartNext()
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `라운드를 시작할 경우 값이 1 깎인다`() {
        val roundNumber = 1
        val round = Round(roundNumber)

        val result = round.startNext()
        assertThat(round.value).isEqualTo(0)
    }
}