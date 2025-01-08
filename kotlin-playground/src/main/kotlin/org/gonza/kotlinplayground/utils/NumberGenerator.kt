package org.gonza.kotlinplayground.utils

import org.gonza.kotlinplayground.config.RacingConstants.RANDOM_NUMBER_MAX_VALUE
import java.util.Random

class NumberGenerator {
    fun generateNumber(): Int {
        val random = Random()
        val number = random.nextInt(RANDOM_NUMBER_MAX_VALUE)

        return number
    }
}