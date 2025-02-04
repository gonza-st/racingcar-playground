package org.gonza.kotlinplayground.presentation

import org.gonza.kotlinplayground.presentation.exception.InvalidTryCountException

class RacingCarGameValidator {
    fun getValidatedTryCountString(tryCount: String?): Int {
        val nonNullTryCount = validateNullOrEmptyTryCount(tryCount)

        return validateStringToIntTryCount(nonNullTryCount)
    }

    fun validateNullOrEmptyTryCount(tryCount: String?): String {
        if (tryCount.isNullOrEmpty()) {
            throw InvalidTryCountException()
        }

        return tryCount
    }

    fun validateStringToIntTryCount(tryCount: String): Int =
        try {
            tryCount.toInt()
        } catch (e: NumberFormatException) {
            throw InvalidTryCountException()
        }
}
