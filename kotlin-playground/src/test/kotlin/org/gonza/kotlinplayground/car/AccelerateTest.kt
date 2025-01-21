package org.gonza.kotlinplayground.car

import org.gonza.kotlinplayground.car.Accelerate
import org.gonza.kotlinplayground.car.Motion
import org.gonza.kotlinplayground.rule.FakeNumberGeneratorImpl
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AccelerateTest {
    @Test
    fun `브레이크를 밟을 수 있다`(){
        val actual = Accelerate(
            numberGenerator = FakeNumberGeneratorImpl(2)
        )

        assertEquals(actual.press(), Motion.BREAK)
    }

    @Test
    fun `엑셀을 밟을 수 있다`(){
        val actual = Accelerate(
            numberGenerator = FakeNumberGeneratorImpl(5)
        )

        assertEquals(actual.press(), Motion.MOVE)
    }
}