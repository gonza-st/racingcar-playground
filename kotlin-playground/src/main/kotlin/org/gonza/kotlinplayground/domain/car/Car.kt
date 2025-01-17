package org.gonza.kotlinplayground.domain.car

import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException

class Car(
    private val name: String,
    private val position: Int
) {
    init {
        validateCarNameLength(name)
    }

    fun move(): Car {
        return Car(name, position + 1)
    }

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }

    private fun validateCarNameLength(name: String) {
        if (name.length > 5) {
            throw InvalidCarNameLengthException()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Car) return false
        return other.getPosition() == position && other.getName() == name
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}