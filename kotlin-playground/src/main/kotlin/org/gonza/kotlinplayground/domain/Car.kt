package org.gonza.kotlinplayground.domain

private const val MOVE_NUMBER = 4

class Car(
    val name: String,
    var position: Position,
    val numberGenerator: NumberGenerator,
) {
    constructor(name: String, numberGenerator: NumberGenerator) : this(name, Position(0), numberGenerator)

    fun move() {
        if (isMovable()) {
            this.position = position.increase()
        }
    }

    fun position(): Int = position.value

    fun positionEqual(other: Int): Boolean = position.value == other

    internal fun checkNumber(): Int = numberGenerator.generate()

    internal fun isMovable(): Boolean = checkNumber() >= MOVE_NUMBER

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (name != other.name) return false
        if (position != other.position) return false
        if (numberGenerator != other.numberGenerator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + numberGenerator.hashCode()
        return result
    }

    override fun toString(): String = "Car(name='$name', position=$position, numberGenerator=$numberGenerator)"
}
