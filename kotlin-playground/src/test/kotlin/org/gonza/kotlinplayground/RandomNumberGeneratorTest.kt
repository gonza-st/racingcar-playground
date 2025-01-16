package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `랜덤 번호는 0-9 사이의 값이다`() {
        val randomNumberGenerator = RandomNumberGenerator(10)
        val generatedNumber = randomNumberGenerator.generate()

        val expectedValue = (0..9).toList()

        Assertions.assertThat(expectedValue).contains(generatedNumber)
    }
}
