package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.utils.StringGenerator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringGeneratorTest {
    @Test
    fun `구분자를 기준으로 문자열을 나눌 수 있다`() {
        val carString = "아반떼,포르쉐,벤츠"
        val generator = StringGenerator()

        val result = generator.generate(carString)

        assertEquals(3, result.size)
    }
}