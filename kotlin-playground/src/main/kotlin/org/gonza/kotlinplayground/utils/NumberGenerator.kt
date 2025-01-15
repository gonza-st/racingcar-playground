package org.gonza.kotlinplayground.utils

import org.gonza.kotlinplayground.config.RacingConstants.RANDOM_NUMBER_MAX_VALUE
import java.util.Random

open class NumberGenerator: Generator<Int> {

    override fun generate(): Int {
        val random = Random()
        val number = random.nextInt(RANDOM_NUMBER_MAX_VALUE)

        return number
    }
}

class TestNumberGenerator(private val fixedNumber: Int): NumberGenerator() {
    override fun generate(): Int = fixedNumber
}