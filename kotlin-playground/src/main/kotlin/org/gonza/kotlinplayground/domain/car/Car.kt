package org.gonza.kotlinplayground.domain.car

import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException

class Car(
    val name: String,
    position: Int,
) {
    private var _position = position

    val position: Int
        get() = _position

    init {
        validateCarNameLength(name)
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }

    fun move(): Car {
        this._position += 1
        return this
    }

    private fun validateCarNameLength(name: String) {
        if (name.length > MAX_NAME_LENGTH) {
            throw InvalidCarNameLengthException()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Car) return false
        return other.position == position && other.name == name
    }

    override fun hashCode(): Int = javaClass.hashCode()
}
