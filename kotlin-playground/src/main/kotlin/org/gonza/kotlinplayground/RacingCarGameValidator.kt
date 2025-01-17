package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.ui.exception.InvalidTryCountException

class RacingCarGameValidator {
    fun getValidatedCarName(carName: String?): String {
        val nonNullCarName = validateNullOrEmptyCarName(carName)

        return nonNullCarName
    }

    fun getValidatedTryCountString(tryCount: String?): Int {
        val nonNullTryCount = validateNullOrEmptyTryCount(tryCount)

        return validateStringToIntTryCount(nonNullTryCount)
    }

    fun validateNullOrEmptyCarName(carName: String?): String {
        if (carName.isNullOrEmpty()) {
            throw EmptyOrNullableCarNameException()
        }
        return carName
    }

    fun validateNullOrEmptyTryCount(tryCount: String?): String {
        if (tryCount.isNullOrEmpty()) {
            throw InvalidTryCountException()
        }

        return tryCount
    }

    fun validateStringToIntTryCount(tryCount: String): Int {
        return try {
            tryCount.toInt()
        } catch (e: NumberFormatException) {
            throw InvalidTryCountException()
        }
    }
}