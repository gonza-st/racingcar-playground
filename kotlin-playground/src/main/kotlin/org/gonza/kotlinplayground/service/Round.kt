package org.gonza.kotlinplayground.service

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.RacingCars
import org.gonza.kotlinplayground.service.dto.GameResult
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount
import org.gonza.kotlinplayground.util.CarNameParser

class Round(
    private val carList: List<Car>,
    private val currentTryCount: TryCount,
) {
    constructor(
        carName: CarName,
        initTryCount: TryCount = TryCount(0),
    ) : this(
        carList =
            CarNameConverter.toCarList(
                carNameList = CarNameParser.parse(carName),
            ),
        currentTryCount = initTryCount,
    )

    fun getCarList(): List<Car> = carList.toList()

    fun start(moveStrategy: MoveStrategy): GameResult {
        val racingCars = RacingCars(carList)

        return GameResult(
            tryCount = TryCount(currentTryCount.value + 1),
            movedCarList = racingCars.move(moveStrategy),
        )
    }

    fun findWinner(): List<CarName> {
        val racingCars = RacingCars(carList)
        return racingCars.findFarthestCarNameList()
    }

    fun isFinished(maxTryCount: TryCount): Boolean = maxTryCount.graterThanOrEqual(currentTryCount)

    // FIXME: 여기 부분을 제거해야할 것 같음, Round 라는 도메인에 걸맞지 않음
    private object CarNameConverter {
        fun toCarList(carNameList: List<CarName>): List<Car> = carNameList.map { Car(it.value, 0) }
    }
}
