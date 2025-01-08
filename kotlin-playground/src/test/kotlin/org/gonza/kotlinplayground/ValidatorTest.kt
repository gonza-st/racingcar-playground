package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ValidatorTest {
    @Test
    fun `문자열 길이를 검증할 수 있다`() {
        val target = "아반떼"
        val validator = Validator()

        assertDoesNotThrow { validator.stringLengthValidate(target = target, length = 5) }
    }
}