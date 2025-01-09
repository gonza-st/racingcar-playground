package org.gonza.kotlinplayground.domain.car

class Car(
    private val name: String,
    private val position: Int
) {
    fun move(): Car {
        return Car(name, position + 1)
    }

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
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