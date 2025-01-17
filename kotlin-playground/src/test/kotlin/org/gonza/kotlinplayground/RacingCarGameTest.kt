package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.dto.toRacingCarGame
import org.gonza.kotlinplayground.vo.CarName
import org.gonza.kotlinplayground.vo.TryCount
import org.junit.jupiter.api.Test

class RacingCarGameTest {
    @Test
    fun `차량 이름을 쉼표를 기준으로 분리할 수 있다`() {
        val carNameList = CarName("이,명,규")
        val carNameListWithSpace = CarName("이,  명,  규")
        val expectedCount = 3

        val racingCarGame1 = RacingCarGame(carNameList)
        val racingCarGame2 = RacingCarGame(carNameListWithSpace)

        assertThat(racingCarGame1.getCarList()).hasSize(expectedCount)
        assertThat(racingCarGame2.getCarList()).hasSize(expectedCount)
    }

    @Test
    fun `게임이 시작하면 게임 횟수가 증가한다`() {
        val carNameList = CarName("이,명,규")
        val initTryCount = TryCount(0)
        val moveStrategy = MoveStrategy{ true }
        val racingCarGame = RacingCarGame(carNameList, initTryCount)

        val result = racingCarGame.start(moveStrategy)
        val resultTryCount = result.tryCount

        assertThat(resultTryCount.value).isEqualTo(initTryCount.value + 1)
    }

    @Test
    fun `게임이 시작하면 차량이 움직인다`() {
        val carNameList = CarName("이,명,규")
        val initTryCount = TryCount(0)
        val moveStrategy = MoveStrategy{ true }
        val racingCarGame1 = RacingCarGame(carNameList, initTryCount)

        val result1 = racingCarGame1.start(moveStrategy)
        val movedCarList1 = result1.movedCarList
        val movedCar1FirstPosition = movedCarList1[0].getPosition()
        val racingCarGame2 = result1.toRacingCarGame()
        val result2 = racingCarGame2.start(moveStrategy)
        val movedCarList2 = result2.movedCarList
        val movedCar1SecondPosition = movedCarList2[0].getPosition()

        assertThat(movedCar1SecondPosition).isEqualTo(movedCar1FirstPosition + 1)
    }
}