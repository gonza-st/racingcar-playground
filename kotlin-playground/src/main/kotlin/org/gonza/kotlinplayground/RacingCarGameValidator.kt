package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidTryCountException

class RacingCarGameValidator {
    fun getValidatedCarName(carName: String?): String {
        if (carName.isNullOrEmpty()) {
            throw EmptyOrNullableCarNameException()
        }

        return carName
    }

    fun getValidatedTryCountString(tryCount: String?): Int {
        if (tryCount.isNullOrEmpty()) {
            throw InvalidTryCountException()
        }

        return try {
            tryCount.toInt()
        } catch (e: NumberFormatException) {
            throw InvalidTryCountException()
        }
    }
}