package org.gonza.kotlinplayground.domain.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarPositionTest {
    @Test
    fun `차 위치는 최초 생성 시 0이다` () {
        val result = CarPosition()
        Assertions.assertThat(result.value).isEqualTo(0)
    }

    @Test
    fun `차는 한 칸씩 움직인다`() {
        val result = CarPosition()
        result.move()
        Assertions.assertThat(result.value).isEqualTo(1)
    }
}