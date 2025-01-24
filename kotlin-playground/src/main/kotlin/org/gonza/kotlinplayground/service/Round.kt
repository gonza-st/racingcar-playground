package org.gonza.kotlinplayground.service

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.RacingCars
import org.gonza.kotlinplayground.service.dto.GameResult
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount

class Round(
    private val carList: List<Car>,
    private val currentGameCount: TryCount,
) {
    constructor(
        carName: CarName,
        initTryCount: TryCount = TryCount(0),
    ) : this(
        carList =
            CarNameConverter.toCarList(
                carNameList = CarNameParser.parse(carName),
            ),
        currentGameCount = initTryCount,
    )

    fun getCarList(): List<Car> = carList.toList()

    fun start(moveStrategy: MoveStrategy): GameResult {
        val racingCars = RacingCars(carList)

        return GameResult(
            tryCount = TryCount(currentGameCount.value + 1),
            movedCarList = racingCars.move(moveStrategy),
        )
    }

    fun findWinner(): String {
        val racingCars = RacingCars(carList)
        val winnerCarList = racingCars.findFarthestCarList()
        val winnerCarNameList = winnerCarList.map { CarName(it.getName()) }
        return CarNameParser.toCarNameString(winnerCarNameList)
    }

    fun isFinished(tryCount: TryCount): Boolean = currentGameCount.value >= tryCount.value

    // FIXME: 여기 부분을 제거해야할 것 같음, Round 라는 도메인에 걸맞지 않음
    private object CarNameParser {
        private const val SPLIT_KEYWORD = ","

        fun parse(carName: CarName): List<CarName> =
            carName.value
                .split(SPLIT_KEYWORD)
                .map { it.trim() }
                .map { CarName(it) }

        fun toCarNameString(carNameList: List<CarName>): String = carNameList.joinToString(SPLIT_KEYWORD) { it.value }
    }

    private object CarNameConverter {
        fun toCarList(carNameList: List<CarName>): List<Car> = carNameList.map { Car(it.value, 0) }
    }
}
