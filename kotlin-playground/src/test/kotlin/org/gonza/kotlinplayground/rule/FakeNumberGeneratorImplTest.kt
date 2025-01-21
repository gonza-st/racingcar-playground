package org.gonza.kotlinplayground.rule

import org.gonza.kotlinplayground.rule.FakeNumberGeneratorImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class FakeNumberGeneratorImplTest {
    @Test
    fun `테스트 시 숫자를 지정하여 생성할 수 있다`(){
        val zero = getFakeNumber(0)
        val nine = getFakeNumber(9)

        assertEquals(zero, 0)
        assertEquals(nine, 9)
    }

    @Test
    fun `0~9 이외의 숫자는 지정하여 생성할 수 없다`(){
        assertThrows<IllegalArgumentException> {
            getFakeNumber(-1)
        }

        assertThrows<IllegalArgumentException> {
            getFakeNumber(10)
        }
    }

    private fun getFakeNumber(number: Int) : Int {
       return FakeNumberGeneratorImpl(number).generate()
    }
}