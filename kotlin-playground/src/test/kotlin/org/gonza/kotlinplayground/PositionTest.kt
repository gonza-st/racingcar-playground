package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `초기화를 수행하면 value가 0이 된다`() {
        val initPosition = Position.init()
        val expectedValue = Position(0)

        Assertions.assertThat(initPosition).isEqualTo(expectedValue)
    }

    @Test
    fun `increase 메소드가 호출되면 Position의 value가 1 증가한다`() {
        val initPosition = Position.init()
        val increasedPosition = initPosition.increase()

        val expectedValue = Position(1)

        Assertions.assertThat(increasedPosition).isEqualTo(expectedValue)
    }
}
