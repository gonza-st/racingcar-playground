package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `문자열 길이를 검증할 수 있다`() {
        val target = "아반떼"
        val validator = Validator()

        assertDoesNotThrow { validator.stringLengthValidate(target = target, length = RacingConstants.DEFAULT_CAR_NAME_LENGTH) }
    }

    @Test
    fun `문자열 길이를 초과하는 경우 예외가 발생한다`() {
        val target = "이것은울트라짱짱캡숑긴자동차이름"
        val validator = Validator()

        assertThrows<IllegalArgumentException> { validator.stringLengthValidate(target = target, length = RacingConstants.DEFAULT_CAR_NAME_LENGTH) }
    }

    @Test
    fun `숫자가 기준값 이상이라면 true를 반환한다`() {
        val validator = Validator()
        val target = 9

        val result = validator.isNumberGreaterThanThreshold(target = target, threshold = RacingConstants.RANDOM_NUMBER_THRESHOLD)

        assertTrue(result)
    }

    @Test
    fun `숫자가 기준값 미만이라면 false를 반환한다`() {
        val validator = Validator()
        val target = 3

        val result = validator.isNumberGreaterThanThreshold(target = target, threshold = RacingConstants.RANDOM_NUMBER_THRESHOLD)

        assertFalse(result)
    }

    @Test
    fun `입력한 값이 없다면 예외가 발생한다`() {
        val emptyString = ""
        val validator = Validator()

        assertThrows<IllegalArgumentException> { validator.validateBlank(emptyString) }
    }

    @Test
    fun `입력값의 구분자가 쉼표인 경우 정상적으로 동작한다`() {
        val validString = "아반떼,봉고,포르쉐"
        val validator = Validator()

        assertDoesNotThrow { validator.validateDelimiter(validString) }
    }

    @Test
    fun `입력값의 구분자가 이상한 경우 예외가 발생한다`() {
        val invalidString = "아반떼.봉고.포르쉐"
        val validator = Validator()

        assertThrows<IllegalArgumentException> { validator.validateDelimiter(invalidString) }
    }
}