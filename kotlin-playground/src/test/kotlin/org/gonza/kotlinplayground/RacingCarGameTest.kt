package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidTryCountException
import org.gonza.kotlinplayground.vo.CarNameByInput
import org.gonza.kotlinplayground.vo.TryCountByInput
import org.junit.jupiter.api.Test

class RacingCarGameTest {
    @Test
    fun `차량 이름을 아무것도 입력하지 않는다면 예외가 발생한다`() {
        val carNameString = CarNameByInput(null)
        val carNameEmptyString = CarNameByInput("")
        val tryCountString = TryCountByInput("1")

        assertThatThrownBy {
            RacingCarGame(carNameString, tryCountString)
        }.isInstanceOf(EmptyOrNullableCarNameException::class.java)

        assertThatThrownBy {
            RacingCarGame(carNameEmptyString, tryCountString)
        }.isInstanceOf(EmptyOrNullableCarNameException::class.java)
    }

    @Test
    fun `차량 이름을 쉼표를 기준으로 분리할 수 있다`() {
        val carNameList = CarNameByInput("이,명,규")
        val carNameListWithSpace = CarNameByInput("이,  명,  규")
        val tryCountString = TryCountByInput("1")
        val expectedCount = 3

        val racingCarGame1 = RacingCarGame(carNameList, tryCountString)
        val racingCarGame2 = RacingCarGame(carNameListWithSpace, tryCountString)

        assertThat(racingCarGame1.getCarNameList()).hasSize(expectedCount)
        assertThat(racingCarGame2.getCarNameList()).hasSize(expectedCount)
    }

    @Test
    fun `차량 경주 게임의 횟수를 입력하지 않는다면 예외가 발생한다`() {
        val tryCountNull = TryCountByInput(null)
        val tryCountEmptyString = TryCountByInput("")
        val carNameString = CarNameByInput("Temp")

        assertThatThrownBy {
            RacingCarGame(carNameString, tryCountNull)
        }.isInstanceOf(InvalidTryCountException::class.java)

        assertThatThrownBy {
            RacingCarGame(carNameString, tryCountEmptyString)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }

    @Test
    fun `차량 경주 게임의 횟수를 정수값이 아닌 알맞지 않은 값을 입력한다면 예외가 발생한다`() {
        val invalidTryCount = TryCountByInput("ddd")
        val carNameString = CarNameByInput("Temp")

        assertThatThrownBy {
            RacingCarGame(carNameString, invalidTryCount)
        }.isInstanceOf(InvalidTryCountException::class.java)
    }
}