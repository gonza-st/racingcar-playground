package org.gonza.kotlinplayground.service.vo

import org.gonza.kotlinplayground.presentation.exception.InvalidTryCountException

data class TryCount(
    val value: Int,
) {
    companion object {
        fun from(value: String?): TryCount {
            if (value.isNullOrEmpty()) {
                throw InvalidTryCountException()
            }

            try {
                return TryCount(value.toInt())
            } catch (e: NumberFormatException) {
                throw InvalidTryCountException()
            }
        }
    }
}
