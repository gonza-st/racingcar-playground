package org.gonza.kotlinplayground.domain.car

import org.gonza.kotlinplayground.utils.NumberGenerator

object CarTestFixture {
    class TestNumberGenerator(
        private val number: Int
    ): NumberGenerator {
        override fun getNumber(): Int = number
    }

    fun getSuccessNumberGenerator() =
        TestNumberGenerator(5)

    fun getFailureNumberGenerator() =
        TestNumberGenerator(3)

}