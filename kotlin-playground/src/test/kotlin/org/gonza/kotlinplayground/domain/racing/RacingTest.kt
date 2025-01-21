package org.gonza.kotlinplayground.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RacingTest {
    val carsName = "test1,test2,test3"
    val round = 10
    @Test
    fun `경주는 텍스트값을 받아 생성된다`() {
        assertDoesNotThrow { Racing(carsName = carsName, round = round) }
    }

    @Test
    fun `경주차는 carsName의 쉼표를 기준으로 구분된다`() {
        val result = Racing(carsName = carsName, round = round)

        assertThat(result.carList.size).isEqualTo(3)
        assertThat(result.carList[0].name).isEqualTo("test1")
        assertThat(result.carList[1].name).isEqualTo("test2")
        assertThat(result.carList[2].name).isEqualTo("test3")
    }

    @Test
    fun `경주차 중 하나의 이름이 5자를 넘길 경우 IllegalArgumentException이 발생한다`() {
        val carsName="test1,over5test,test3"
        assertThrows<IllegalArgumentException> { Racing(carsName = carsName, round = round) }
    }

    @Test
    fun `경주는 입력받은 만큼의 라운드를 가진다`() {
        val result = Racing(carsName = carsName, round = round)
        assertThat(result.round.value).isEqualTo(round)
    }

    @Test
    fun `라운드는 0보다 작을 수 없다`() {
        val round = -1
        assertThrows<IllegalArgumentException> { Racing(carsName = carsName, round = round) }
    }
}