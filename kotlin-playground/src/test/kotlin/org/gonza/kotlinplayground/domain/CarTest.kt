package org.gonza.kotlinplayground.domain

import Car
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `차는 이름을 받아 생성된다`() {
        val name = "name"

        assertDoesNotThrow { Car(name) }
    }
}