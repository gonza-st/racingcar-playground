package org.gonza.kotlinplayground.domain

class CarName(
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CarName) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int = value.hashCode()
}
