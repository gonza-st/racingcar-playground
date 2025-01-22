package org.gonza.kotlinplayground.rule

import org.gonza.kotlinplayground.rule.NumberGeneratorImpl
import org.junit.jupiter.api.Test

class NumberGeneratorImplTest {
    val sut = NumberGeneratorImpl()

    @Test
    fun `0~9 사이의 임의의 숫자를 생성할 수 있다`(){
        val actual = sut.generate()

        assert(actual is Int)
        assert(actual in 0..9)
    }

    @Test
    fun `반복적으로 생성해도 0~9 사이일 수 있다`(){
        for(i in 1..100){
            val actual = sut.generate()
            assert(actual in 0..9)
        }
    }

}