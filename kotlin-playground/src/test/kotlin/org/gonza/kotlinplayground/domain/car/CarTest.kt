package org.gonza.kotlinplayground.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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
    fun `최초 차의 위치는 0이다`() {
        val result = Car(name)
        assertThat(result.position).isEqualTo(0)
    }

    @Test
    fun `랜덤 값이 4 이상일 경우 차는 한 칸 앞으로 간다`() {
        val successNumberGenerator = CarTestFixture.getSuccessNumberGenerator()
        val result = Car(name, successNumberGenerator)

        result.move()
        assertThat(result.position).isEqualTo(1)
    }

    @Test
    fun `랜덤 값이 4 이하일 경우 차는 그대로 있는다`() {
        val failureNumberGenerator = CarTestFixture.getFailureNumberGenerator()
        val result = Car(name, failureNumberGenerator)

        result.move()
        assertThat(result.position).isEqualTo(0)
    }
}