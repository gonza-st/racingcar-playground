package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.vo.CarNameByInput
import org.gonza.kotlinplayground.vo.TryCountByInput
import org.junit.jupiter.api.Test

class RacingCarGameTest {
    @Test
    fun `차량 이름을 쉼표를 기준으로 분리할 수 있다`() {
        val carNameList = CarNameByInput("이,명,규")
        val carNameListWithSpace = CarNameByInput("이,  명,  규")
        val tryCount = TryCountByInput(1)
        val expectedCount = 3

        val racingCarGame1 = RacingCarGame(carNameList, tryCount)
        val racingCarGame2 = RacingCarGame(carNameListWithSpace, tryCount)

        assertThat(racingCarGame1.getCarNameList()).hasSize(expectedCount)
        assertThat(racingCarGame2.getCarNameList()).hasSize(expectedCount)
    }
}