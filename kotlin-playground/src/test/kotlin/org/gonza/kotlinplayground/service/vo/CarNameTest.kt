package org.gonza.kotlinplayground.service.vo

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.presentation.exception.EmptyOrNullableCarNameException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarNameTest {
    @Test
    fun `차량 이름을 null 로 생성하면 예외가 발생한다`() {
        val value = null

        assertThatThrownBy {
            CarName.from(value)
        }.isInstanceOf(EmptyOrNullableCarNameException::class.java)
    }

    @Test
    fun `차량 이름을 빈 문자열로 생성하면 예외가 발생한다`() {
        val value = ""

        assertThatThrownBy {
            CarName.from(value)
        }.isInstanceOf(EmptyOrNullableCarNameException::class.java)
    }

    @Test
    fun `입력한 값으로 차량이름을 생성할 수 있다`() {
        val value = "test"

        val carName = CarName.from(value)

        assertThat(carName.value).isEqualTo(value)
    }
}
