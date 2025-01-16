package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarNameTest {
    @Test
    fun `이름은 5자를 초과할 수 없다`() {
        Assertions
            .assertThatThrownBy { CarName("123456") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 5자를 초과할 수 없습니다.")
    }

    @Test
    fun `이름의 길이는 양쪽 빈값을 제외한 길이가 5를 초과하지 않는다`() {
        val carName = CarName(" 1234 ")
        val expectedValue = CarName(" 1234 ")

        Assertions.assertThat(carName).isEqualTo(expectedValue)
    }
}
