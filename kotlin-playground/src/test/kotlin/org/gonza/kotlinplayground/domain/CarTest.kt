package org.gonza.kotlinplayground.domain

import Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarTest {
    val name = "name"
    @Test
    fun `차는 이름을 받아 생성된다`() {
        val result = Car(name)
        assertThat(result.name).isEqualTo(name)
    }

    @Test
    fun `이름이 5자를 초과할 수 없다` () {
        val name = "longerthanfive"
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @Test
    fun `차는 최초로 생성될 시 position이 0이다` () {
        val result = Car(name)
        assertThat(result.position).isEqualTo(0)
    }

    @Test
    fun `차는 한 칸씩 움직인다`() {
        val result = Car(name)
        assertThat(result.position).isEqualTo(0)
        result.move()
        assertThat(result.position).isEqualTo(1)
    }
}