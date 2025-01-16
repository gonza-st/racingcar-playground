package org.gonza.kotlinplayground.fixture

import org.gonza.kotlinplayground.domain.NumberGenerator

class StayNumberGenerator(
    override val range: Int = 10,
) : NumberGenerator {
    override fun generate(): Int = 3
}
