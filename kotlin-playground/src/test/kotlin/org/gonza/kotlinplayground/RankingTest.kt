package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.domain.Cars
import org.gonza.kotlinplayground.domain.Ranking
import org.gonza.kotlinplayground.ui.PrintView
import org.gonza.kotlinplayground.utils.TestNumberGenerator
import org.gonza.kotlinplayground.utils.Validator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RankingTest {

    private val validator = Validator()
    private val generator = TestNumberGenerator(5)

    @Test
    fun `자동차 경주가 시작되면 자동차의 거리를 표시한다`() {
        val car1 = Car(name = "아반따", validator = validator, generator = generator)
        val car2 = Car(name = "폴쉐", validator = validator, generator = generator)
        val car3 = Car(name = "벤스", validator = validator, generator = generator)
        val carList = listOf(car1, car2, car3)
        val cars = Cars(carList)
        val movedCarList = cars.moveAll()
        val expectedRankList = carList.map {
            "${it.name} : ${"-".repeat(it.distance)}"
        }

        val ranking = Ranking()
        val rankList = ranking.rank(movedCarList)

        assertEquals(expectedRankList, rankList)
    }
}