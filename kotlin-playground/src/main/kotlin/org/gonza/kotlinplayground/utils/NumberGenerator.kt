package org.gonza.kotlinplayground.utils

import java.util.Random

open class NumberGenerator: TargetGenerator<Int, Int> {

    override fun generate(target: Int): Int {
        val random = Random()
        val number = random.nextInt(target)

        return number
    }
}

class TestNumberGenerator(private val fixedNumber: Int): NumberGenerator() {
    override fun generate(target: Int): Int = fixedNumber
}