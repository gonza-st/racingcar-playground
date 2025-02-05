package org.gonza.kotlinplayground.domain.car

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 전진하면 위치가 변경된다`() {
        val initPosition = 0
        val initName = "name"
        val car = Car(initName, initPosition)

        val movedCar = car.move()

        assertThat(initPosition).isNotEqualTo(movedCar.position)
        assertThat(movedCar.position).isEqualTo(initPosition + 1)
    }

    @Test
    fun `자동차의 이름과 위치가 같은 두 자동차는 동일한 자동차이다`() {
        val car1 = Car("name", 1)
        val car2 = Car("name", 1)
        val otherCar = Car("name", 2)

        assertThat(car1).isEqualTo(car2)
        assertThat(car1).isNotEqualTo(otherCar)
        assertThat(car2).isNotEqualTo(otherCar)
    }

    @Test
    fun `자동차의 이름은 5글자를 초과할 수 없다`() {
        assertThatThrownBy {
            Car("123456", 1)
        }.isInstanceOf(InvalidCarNameLengthException::class.java)
    }
}
