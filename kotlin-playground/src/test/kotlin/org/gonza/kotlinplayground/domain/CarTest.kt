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

    @Test
    fun `이름이 5자를 초과할 수 없다` () {
        val name = "longerthanfive"

        assertThrows<Exception> { Car(name) }
    }
}