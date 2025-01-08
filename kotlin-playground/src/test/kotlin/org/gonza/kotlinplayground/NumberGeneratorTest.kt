package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.utils.NumberGenerator
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class NumberGeneratorTest {
    @Test
    fun `0부터 9사이의 숫자를 임의로 생성한다`() {
        val generator = NumberGenerator()

        repeat(1000) {
            val actual = generator.generateNumber()
            assertTrue { actual >= RacingConstants.RANDOM_NUMBER_MIN_VALUE }
            assertTrue { actual < RacingConstants.RANDOM_NUMBER_MAX_VALUE }
        }
    }
}