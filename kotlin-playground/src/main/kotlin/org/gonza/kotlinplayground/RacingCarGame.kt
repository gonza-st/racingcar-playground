package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidTryCountException
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
        val validatedCarNameString = getValidatedCarNameString(carNameByInput.value)
        val validatedTryCount = getValidatedTryCountString(tryCountByInput.value)
        carNameList = getCarNameByInput(validatedCarNameString)
        tryCount = validatedTryCount
    }

    fun getCarNameList(): List<String> = carNameList

    private fun getValidatedCarNameString(carNameList: String?): String {
        if (carNameList.isNullOrEmpty()) {
            throw EmptyOrNullableCarNameException()
        }

        return carNameList
    }

    private fun getValidatedTryCountString(tryCount: String?): Int {
        if (tryCount.isNullOrEmpty()) {
            throw InvalidTryCountException()
        }
        return try {
            tryCount.toInt()
        } catch (e: NumberFormatException) {
            throw InvalidTryCountException()
        }
    }

    private fun getCarNameByInput(carName: String): List<String> {
        return carName.split(splitKeyword).map { it.trim() }
    }
}