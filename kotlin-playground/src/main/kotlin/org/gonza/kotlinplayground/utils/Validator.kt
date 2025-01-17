package org.gonza.kotlinplayground.utils

import org.gonza.kotlinplayground.config.RacingConstants

class Validator {
    fun stringLengthValidate(target: String, length: Int) {
        if (target.length > length) {
            throw IllegalArgumentException("문자열의 길이가 입력한 길이를 초과합니다.")
        }

        return
    }

    fun isNumberGreaterThanThreshold(target: Int, threshold: Int): Boolean {
        return target >= threshold
    }

    fun validateBlank(target: String) {
        if (target.isBlank()) {
            throw IllegalArgumentException("문자열이 빈 값입니다.")
        }

        return
    }

    fun validateDelimiter(target: String) {
        val trimmedString = target.trim()
        val invalidString = trimmedString.filter { char ->
            char.toString().matches(RacingConstants.INPUT_REGEX.toRegex()) &&
                    char.toString() != RacingConstants.INPUT_DELIMITER
        }

        if (invalidString.isNotBlank()) {
            throw IllegalArgumentException("구분자는 ','만 허용됩니다.")
        }
    }

    fun validateDigit(digitString: String) {
        try {
            digitString.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자로 변환할 수 없습니다.")
        }
    }

}