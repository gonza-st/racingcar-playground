package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StringSplitterTest {
    @Test
    fun `,를 구분자로 문자열을 List로 만든다`() {
        val nameString = "이름1,이름2,이름3"
        val nameList = StringSplitter.split(nameString)

        val expectedList = listOf("이름1", "이름2", "이름3")

        Assertions.assertThat(nameList).isEqualTo(expectedList)
    }

    @Test
    fun `다른 구분자가 문자열에 포함되면 하나의 문자열로 반환된다`() {
        val nameString = "이름1|이름2|이름3"
        val nameList = StringSplitter.split(nameString)

        val expectedValue = listOf("이름1|이름2|이름3")

        Assertions.assertThat(nameList).isEqualTo(expectedValue)
    }

    @Test
    fun `빈 문자열이 들어오면 에러가 발생한다`() {
        val nameString = ""
        Assertions
            .assertThatThrownBy { StringSplitter.split(nameString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("나누려는 문자열은 빈 문자열일 수 없습니다")
    }

    @Test
    fun `구분한 후에 양쪽 빈 문자를 지운다`() {
        val nameString = " LMK, LMK1, LMK2 "
        val nameList = StringSplitter.split(nameString)

        val expectedValue = listOf("LMK", "LMK1", "LMK2")

        Assertions.assertThat(nameList).isEqualTo(expectedValue)
    }

    @Test
    fun `구분한 문자열 List가 중복값이 있다면 에러가 발생한다`() {
        val nameString = "LMK, LMK, LMK"
        Assertions
            .assertThatThrownBy { StringSplitter.split(nameString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("나누려는 문자열은 중복일 수 없습니다")
    }

    @Test
    fun `구분자만 있다면 에러가 발생한다`() {
        val nameString = ",,,,,"

        Assertions
            .assertThatThrownBy { StringSplitter.split(nameString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("나누려는 문자열은 빈 문자열일 수 없습니다")
    }
}
