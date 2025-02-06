package org.gonza.kotlinplayground.domain

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.utils.NumberGenerator
import org.gonza.kotlinplayground.utils.Validator

class Car(
    val name: String,
    private val validator: Validator,
    private val generator: NumberGenerator,
) {
    init {
        validator.stringLengthValidate(target = name, length = RacingConstants.DEFAULT_CAR_NAME_LENGTH)
    }

    var distance: Int = 0
        private set

    fun move() {
        if (isMoveable()) {
            distance++
        }
    }

    private fun isMoveable(): Boolean {
        val number = generator.generate(RacingConstants.RANDOM_NUMBER_MAX_VALUE)
        return validator.isNumberGreaterThanThreshold(
            target = number,
            threshold = RacingConstants.RANDOM_NUMBER_THRESHOLD
        )
    }
}
