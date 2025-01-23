package org.gonza.kotlinplayground.service

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.service.dto.toRacingCarGame
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `차량 이름을 쉼표를 기준으로 분리할 수 있다`() {
        val carNameList = CarName("이,명,규")
        val carNameListWithSpace = CarName("이,  명,  규")
        val expectedCount = 3

        val round1 = Round(carNameList)
        val round2 = Round(carNameListWithSpace)

        assertThat(round1.getCarList()).hasSize(expectedCount)
        assertThat(round2.getCarList()).hasSize(expectedCount)
    }

    @Test
    fun `라운드를 시작하면 게임 횟수가 증가한다`() {
        val carNameList = CarName("이,명,규")
        val initTryCount = TryCount(0)
        val moveStrategy = MoveStrategy{ true }
        val round = Round(carNameList, initTryCount)

        val result = round.start(moveStrategy)
        val resultTryCount = result.tryCount

        assertThat(resultTryCount.value).isEqualTo(initTryCount.value + 1)
    }

    @Test
    fun `라운드를 시작하면 차량이 움직인다`() {
        val carNameList = CarName("이,명,규")
        val initTryCount = TryCount(0)
        val moveStrategy = MoveStrategy{ true }
        val round1 = Round(carNameList, initTryCount)

        val result1 = round1.start(moveStrategy)
        val movedCarList1 = result1.movedCarList
        val movedCar1FirstPosition = movedCarList1[0].getPosition()
        val racingCarGame2 = result1.toRacingCarGame()
        val result2 = racingCarGame2.start(moveStrategy)
        val movedCarList2 = result2.movedCarList
        val movedCar1SecondPosition = movedCarList2[0].getPosition()

        assertThat(movedCar1SecondPosition).isEqualTo(movedCar1FirstPosition + 1)
    }

    @Test
    fun `라운드가 끝났다면 게임이 끝났다는 결과는 참이다`() {
        val endTryCount = TryCount(5)
        val initTryCount = TryCount(0)
        val round = Round(
            carList = emptyList(),
            currentGameCount = initTryCount
        )
        val testMoveStrategy = MoveStrategy{ true }

        val result1 = round.start(testMoveStrategy)
        val result2 = result1.toRacingCarGame().start(testMoveStrategy)
        val result3 = result2.toRacingCarGame().start(testMoveStrategy)
        val result4 = result3.toRacingCarGame().start(testMoveStrategy)
        val result5 = result4.toRacingCarGame().start(testMoveStrategy)
        val endRacingCarGame = result5.toRacingCarGame()

        assertThat(endRacingCarGame.isFinished(endTryCount)).isTrue()
    }

    @Test
    fun `라운드가 끝났다면 게임이 끝났다는 결과는 거짓이다`() {
        val endTryCount = TryCount(5)
        val initTryCount = TryCount(0)
        val round = Round(
            carList = emptyList(),
            currentGameCount = initTryCount
        )
        val testMoveStrategy = MoveStrategy{ true }

        val result1 = round.start(testMoveStrategy)
        val result2 = result1.toRacingCarGame().start(testMoveStrategy)
        val result3 = result2.toRacingCarGame().start(testMoveStrategy)
        val result4 = result3.toRacingCarGame().start(testMoveStrategy)
        val endRacingCarGame = result4.toRacingCarGame()

        assertThat(endRacingCarGame.isFinished(endTryCount)).isFalse()
    }

    @Test
    fun `라운드에서 이긴 차량의 이름을 조회할 수 있다`() {
        val car1 = Car(
            name = "car1",
            position = 1
        )
        val car2 = Car(
            name = "car2",
            position = 2
        )
        val winner = Car(
            name = "win",
            position = 100
        )
        val round = Round(
            carList = listOf(car1, car2, winner),
            currentGameCount = TryCount(1)
        )

        val result = round.findWinner()

        assertThat(result).isEqualTo(winner.getName())
    }

    @Test
    fun `라운드에서 이긴 차량이 여러 차량이라면 이어서 이름이 표현되어야 한다`() {
        val car1 = Car(
            name = "car1",
            position = 1
        )
        val winner1 = Car(
            name = "win1",
            position = 100
        )
        val winner2 = Car(
            name = "win2",
            position = 100
        )
        val round = Round(
            carList = listOf(car1, winner1, winner2),
            currentGameCount = TryCount(1)
        )
        val expected = "${winner1.getName()},${winner2.getName()}"

        val result = round.findWinner()

        assertThat(result).isEqualTo(expected)
    }
}
