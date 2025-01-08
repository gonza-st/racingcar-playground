package org.gonza.kotlinplayground.domain

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.utils.Validator

class Car(
    val name: String,
    validator: Validator,
) {
    init {
        validator.stringLengthValidate(name, RacingConstants.DEFAULT_CAR_NAME_LENGTH)
    }

    var distance: Int = 0
        private set

    fun move() {
        distance++
    }
}
