package org.gonza.kotlinplayground

class StayNumberGenerator(
    override val range: Int = 10,
) : NumberGenerator {
    override fun generate(): Int = 3
}
