package org.gonza.kotlinplayground.util

import org.assertj.core.api.Assertions.assertThat
import org.gonza.kotlinplayground.service.vo.CarName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarNameParserTest {
    @Test
    fun `차량 이름을 쉼표를 기준으로 분리할 수 있다`() {
        val carNameList = CarName("이,명,규")
        val carNameListWithSpace = CarName("이,  명,  규")
        val expectedCount = 3

        val result1 = CarNameParser.parse(carNameList)
        val result2 = CarNameParser.parse(carNameListWithSpace)

        assertThat(result1).hasSize(expectedCount)
        assertThat(result2).hasSize(expectedCount)
    }
}
