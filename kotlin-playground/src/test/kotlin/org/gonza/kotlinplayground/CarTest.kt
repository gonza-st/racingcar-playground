package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Car
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

class CarTest {
    @Test
    fun `자동차는 이름을 가질 수 있다`() {
        val validName = "봉고"
        val car = Car(name = validName)

        assertTrue { car.name.isNotBlank() }
    }

    @Test
    fun `자동차의 이름은 5자를 초과할 수 없다`() {
        val invalidName = "이것은_울트라_짱짱긴_자동차이름"

        assertThrows<IllegalArgumentException> { Car(name = invalidName) }
    }
}