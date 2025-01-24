package org.gonza.kotlinplayground.fixture

import org.gonza.kotlinplayground.domain.NumberGenerator

class MovedNumberGenerator(
    override val range: Int = 10,
) : NumberGenerator {
    override fun generate(): Int = 4
}
