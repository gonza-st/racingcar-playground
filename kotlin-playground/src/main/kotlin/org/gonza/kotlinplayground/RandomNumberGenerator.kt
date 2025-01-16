package org.gonza.kotlinplayground

import java.util.Random

private const val DEFAULT_RANGE = 10

class RandomNumberGenerator(
    override val range: Int = DEFAULT_RANGE,
) : NumberGenerator {
    private val random = Random()

    override fun generate(): Int = random.nextInt(range)
}
