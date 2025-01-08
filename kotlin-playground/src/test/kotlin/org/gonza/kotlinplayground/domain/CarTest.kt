package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 전진하면 위치가 변경된다`() {
        val initPosition = 0
        val car = Car(initPosition)

        val movedCar1 = car.move()
        val movedCar2 = movedCar1.move()

        assertThat(initPosition).isNotEqualTo(movedCar1.getPosition())
        assertThat(movedCar1.getPosition()).isNotEqualTo(movedCar2.getPosition())
    }
}