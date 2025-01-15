package org.gonza.kotlinplayground

class NumberGeneratorImpl : NumberGenerator {
    override fun generate(): Int = (0..9).random()
}
