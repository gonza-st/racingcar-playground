package org.gonza.kotlinplayground.domain

import org.assertj.core.api.Assertions
import org.gonza.kotlinplayground.fixture.TestFixture
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차를 생성할 때 이름과 번호생성기로 생성한다`() {
        val movedNumberGenerator = TestFixture.getMovedNumberGenerator()
        val car = Car(name = "아반떼", numberGenerator = movedNumberGenerator)

        Assertions.assertThat(car).isNotNull
        Assertions.assertThat(car).hasFieldOrProperty("name")
        Assertions.assertThat(car).hasFieldOrProperty("numberGenerator")
    }

    @Test
    fun `동일한 값을 가진 자동차는 같다`() {
        val movedNumberGenerator = TestFixture.getMovedNumberGenerator()
        val firstCar = Car(name = "아반떼", numberGenerator = movedNumberGenerator)
        val secondCar = Car(name = "아반떼", numberGenerator = movedNumberGenerator)

        Assertions.assertThat(firstCar).isEqualTo(secondCar)
    }

    @Test
    fun `checkNumber로 번호를 확인한다`() {
        val movedNumberGenerator = TestFixture.getMovedNumberGenerator()
        val car = Car(name = "아반떼", numberGenerator = movedNumberGenerator)

        val checkedNumber = car.checkNumber()

        val expectedNumber = 4L

        Assertions.assertThat(checkedNumber).isEqualTo(expectedNumber)
    }

    @Test
    fun `번호가 4이상이면 이동가능하다고 판단한다`() {
        val movedNumberGenerator = TestFixture.getMovedNumberGenerator()
        val car = Car(name = "아반떼", numberGenerator = movedNumberGenerator)

        val isMovable = car.isMovable()

        val expectedValue = true

        Assertions.assertThat(isMovable).isEqualTo(expectedValue)
    }

    @Test
    fun `번호가 4이상이면 이동한다`() {
        val movedNumberGenerator = TestFixture.getMovedNumberGenerator()
        val car = Car(name = "아반떼", numberGenerator = movedNumberGenerator)

        car.move()

        val expectedValue = Car(name = "아반떼", position = Position(1), numberGenerator = movedNumberGenerator)

        Assertions.assertThat(car).isEqualTo(expectedValue)
    }

    @Test
    fun `동일한 위치인지 반환한다`() {
        val movedNumberGenerator = TestFixture.getMovedNumberGenerator()
        val car = Car(name = "아반떼", numberGenerator = movedNumberGenerator)
        car.move()

        val isSamePosition = car.positionEqual(1)

        val expectedValue = true

        Assertions.assertThat(isSamePosition).isEqualTo(expectedValue)
    }
}
