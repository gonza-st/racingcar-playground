package org.gonza.kotlinplayground.dto

import org.gonza.kotlinplayground.RacingCarGame
import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.vo.TryCount

data class GameResult(
    val tryCount: TryCount,
    val movedCarList: List<Car>
)

fun GameResult.toRacingCarGame(): RacingCarGame =
    RacingCarGame(
        carList = this.movedCarList,
        currentGameCount = this.tryCount
    )
