package org.gonza.kotlinplayground.service

import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.RacingCars
import org.gonza.kotlinplayground.service.dto.GameResult
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount

class Round(
    private val racingCars: RacingCars,
    private val currentTryCount: TryCount = TryCount(0),
) {
    fun start(moveStrategy: MoveStrategy): GameResult =
        GameResult(
            tryCount = TryCount(currentTryCount.value + 1),
            movedCarList = racingCars.move(moveStrategy),
        )

    fun findWinner(): List<CarName> = racingCars.findFarthestCarNameList()

    fun isFinished(maxTryCount: TryCount): Boolean = maxTryCount.graterThanOrEqual(currentTryCount)

    // FIXME: 여기 부분을 제거해야할 것 같음, Round 라는 도메인에 걸맞지 않음
}
