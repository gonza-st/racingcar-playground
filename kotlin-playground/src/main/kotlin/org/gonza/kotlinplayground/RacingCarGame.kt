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
        carList = with(RacingCarConverter) {
            val parsedCarName = parseCarName(carName.value)
            toCarList(parsedCarName)
        },
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

    private object RacingCarConverter {
        private const val SPLIT_KEYWORD = ","

        fun toCarList(carNameList: List<String>): List<Car> =
            carNameList.map { Car(it, 0) }

        fun parseCarName(carName: String): List<String> =
            carName.split(SPLIT_KEYWORD).map { it.trim() }
    }
}