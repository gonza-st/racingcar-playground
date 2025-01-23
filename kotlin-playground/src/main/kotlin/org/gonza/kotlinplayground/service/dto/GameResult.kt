package org.gonza.kotlinplayground.service.dto

import org.gonza.kotlinplayground.service.Round
import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.service.vo.TryCount

data class GameResult(
    val tryCount: TryCount,
    val movedCarList: List<Car>
)

fun GameResult.toRacingCarGame(): Round =
    Round(
        carList = this.movedCarList,
        currentGameCount = this.tryCount
    )
