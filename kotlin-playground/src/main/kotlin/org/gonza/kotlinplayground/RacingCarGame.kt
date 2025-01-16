package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.vo.CarNameByInput
import org.gonza.kotlinplayground.vo.TryCountByInput

class RacingCarGame(
    carNameByInput: CarNameByInput,
    tryCountByInput: TryCountByInput
) {
    private val splitKeyword = ","

    private val carNameList: List<String>

    private val tryCount: Int

    init {
        carNameList = getCarNameByInput(carNameByInput.value)
        tryCount = tryCountByInput.value
    }

    fun getCarNameList(): List<String> = carNameList

    private fun getCarNameByInput(carName: String): List<String> {
        return carName.split(splitKeyword).map { it.trim() }
    }
}