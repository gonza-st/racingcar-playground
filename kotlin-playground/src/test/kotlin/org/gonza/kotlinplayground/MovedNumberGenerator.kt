package org.gonza.kotlinplayground

class MovedNumberGenerator(
    override val range: Int = 10,
) : NumberGenerator {
    override fun generate(): Int = 4
}
