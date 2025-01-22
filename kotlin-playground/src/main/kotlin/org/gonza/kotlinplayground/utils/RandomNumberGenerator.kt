package org.gonza.kotlinplayground.utils

import kotlin.random.Random

class RandomNumberGenerator(
    val start: Int = 0,
    val end: Int = 9
): NumberGenerator {
    override fun getNumber(): Int {
        return Random.nextInt(start, end)
    }
}