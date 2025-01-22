package org.gonza.kotlinplayground.presentation

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.gonza.kotlinplayground.presentation.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.presentation.exception.InvalidTryCountException
import org.junit.jupiter.api.Test

class RacingCarGameValidatorTest {
    @Test
    fun `차량 이름을 아무것도 입력하지 않는다면 예외가 발생한다`() {
        val carNameString = null
        val carNameEmptyString = ""
        val validator = RacingCarGameValidator()

        assertThatThrownBy {
            validator.validateNullOrEmptyCarName(carNameString)
        }.isInstanceOf(EmptyOrNullableCarNameException::class.java)

        assertThatThrownBy {
            validator.validateNullOrEmptyCarName(carNameEmptyString)
        }.isInstanceOf(EmptyOrNullableCarNameException::class.java)
    }

    @Test
    fun `차량 경주 게임의 횟수를 입력하지 않는다면 예외가 발생한다`() {
        val tryCountNull = null
        val tryCountEmptyString = ""
        val validator = RacingCarGameValidator()

        assertThatThrownBy {
            validator.validateNullOrEmptyTryCount(tryCountNull)
        }.isInstanceOf(InvalidTryCountException::class.java)

        assertThatThrownBy {
            validator.validateNullOrEmptyTryCount(tryCountEmptyString)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }

    @Test
    fun `차량 경주 게임의 횟수를 정수값이 아닌 알맞지 않은 값을 입력한다면 예외가 발생한다`() {
        val invalidTryCount = "ddd"
        val validator = RacingCarGameValidator()

        assertThatThrownBy {
            validator.validateStringToIntTryCount(invalidTryCount)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }
}