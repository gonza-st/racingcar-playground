package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.dto.GameResult
import org.gonza.kotlinplayground.vo.CarName
import org.gonza.kotlinplayground.vo.TryCount

class RacingCarGame(
    carName: CarName,
    initTryCount: TryCount = TryCount(0)
) {
    private val splitKeyword = ","

    private val carNameList: List<String>

    private val currentGameCount = initTryCount

    init {
        carNameList = getCarNameByInput(carName.value)
    }

    fun getCarNameList(): List<String> = carNameList.toList()

    private fun getCarNameByInput(carName: String): List<String> {
        return carName.split(splitKeyword).map { it.trim() }
    }

    fun start(): GameResult {
        return GameResult(
            tryCount = TryCount(currentGameCount.value),
        )
    }
}