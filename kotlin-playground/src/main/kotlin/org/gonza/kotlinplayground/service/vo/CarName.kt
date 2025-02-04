package org.gonza.kotlinplayground.service.vo

import org.gonza.kotlinplayground.presentation.exception.EmptyOrNullableCarNameException

data class CarName(
    val value: String,
) {
    companion object {
        fun from(value: String?): CarName {
            if (value.isNullOrEmpty()) {
                throw EmptyOrNullableCarNameException()
            }
            return CarName(value)
        }
    }
}
