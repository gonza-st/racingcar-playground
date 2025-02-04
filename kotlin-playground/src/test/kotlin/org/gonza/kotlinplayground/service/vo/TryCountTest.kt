package org.gonza.kotlinplayground.service.vo

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.presentation.exception.InvalidTryCountException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TryCountTest {
    @Test
    fun `입력한 값이 null 이라면 예외가 발생한다`() {
        val value = null

        assertThatThrownBy {
            TryCount.from(value)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }

    @Test
    fun `입력한 값이 빈 문자열이라면 예외가 발생한다`() {
        val value = ""

        assertThatThrownBy {
            TryCount.from(value)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }

    @Test
    fun `입력한 값이 정수값이 아니라면 예외가 발생한다`() {
        val value = "ddd"

        assertThatThrownBy {
            TryCount.from(value)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }

    @Test
    fun `입력한 값으로 횟수를 생성할 수 있다`() {
        val value = "1"

        val result = TryCount.from(value)

        assertThat(result.value).isEqualTo(value.toInt())
    }
}
