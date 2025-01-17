package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions.*
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

        assertThat(racingCarGame1.getCarNameList()).hasSize(expectedCount)
        assertThat(racingCarGame2.getCarNameList()).hasSize(expectedCount)
    }

    @Test
    fun `게임이 시작하면 게임 횟수가 증가한다`() {
        val carNameList = CarName("이,명,규")
        val initTryCount = TryCount(0)
        val racingCarGame = RacingCarGame(carNameList, initTryCount)

        val result = racingCarGame.start()
        val resultTryCount = result.tryCount

        assertThat(resultTryCount.value).isEqualTo(initTryCount.value + 1)
    }
}