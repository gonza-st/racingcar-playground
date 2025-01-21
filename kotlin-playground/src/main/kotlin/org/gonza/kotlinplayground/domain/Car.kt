package org.gonza.kotlinplayground.domain

private const val MOVE_NUMBER = 4

data class Car(
    val name: String,
    var position: Position,
    val numberGenerator: NumberGenerator,
) {
    constructor(name: String, numberGenerator: NumberGenerator) : this(name, Position.init(), numberGenerator)

    fun move() {
        if (isMovable()) {
            this.position = position.increase()
        }
    }

    fun position(): Int = position.value

    fun positionEqual(other: Int): Boolean = position.value == other

    internal fun checkNumber(): Int = numberGenerator.generate()

    internal fun isMovable(): Boolean = checkNumber() >= MOVE_NUMBER
}
