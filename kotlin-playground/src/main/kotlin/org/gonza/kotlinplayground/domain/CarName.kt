package org.gonza.kotlinplayground.domain

data class CarName(
    val value: String,
) {
    init {
        validate(value)
    }

    private fun validate(value: String) {
        val trimmedValue = value.trim()

        if (trimmedValue.length > 5) {
            throw IllegalArgumentException("이름은 5자를 초과할 수 없습니다.")
        }
    }
}
