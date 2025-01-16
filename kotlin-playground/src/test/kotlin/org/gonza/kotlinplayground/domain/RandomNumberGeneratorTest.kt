package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `랜덤 번호는 범위 사이의 값이다`() {
        val range = 10
        val randomNumberGenerator = RandomNumberGenerator(range)
        val generatedNumber = randomNumberGenerator.generate()

        val expectedValue = (0..9).toList()

        Assertions.assertThat(expectedValue).contains(generatedNumber)
    }
}
