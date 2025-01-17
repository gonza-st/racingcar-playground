package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.RacingCars
import org.gonza.kotlinplayground.dto.GameResult
import org.gonza.kotlinplayground.vo.CarName
import org.gonza.kotlinplayground.vo.TryCount

class RacingCarGame(
    private val carList: List<Car>,
    private val currentGameCount: TryCount
) {
    constructor(
        carName: CarName,
        initTryCount: TryCount = TryCount(0)
    ) : this(
        carList = CarNameConverter.toCarList(
            carNameList = CarNameParser.parse(carName)
        ),
        currentGameCount = initTryCount
    )

    fun getCarList(): List<Car> = carList.toList()

    fun start(moveStrategy: MoveStrategy): GameResult {
        val racingCars = RacingCars(carList)

        return GameResult(
            tryCount = TryCount(currentGameCount.value + 1),
            movedCarList = racingCars.move(moveStrategy)
        )
    }

    fun isFinished(tryCount: TryCount): Boolean =
        currentGameCount.value >= tryCount.value

    private object CarNameParser {
        private const val SPLIT_KEYWORD = ","

        fun parse(carName: CarName): List<CarName> =
            carName.value.split(SPLIT_KEYWORD)
                .map { it.trim() }
                .map { CarName(it) }
    }

    private object CarNameConverter {
        fun toCarList(carNameList: List<CarName>): List<Car> =
            carNameList.map { Car(it.value, 0) }
    }
}
