package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.exception.EmptyOrNullableCarNameException

class RacingCarGame(
    carName: String?,
) {
    private val splitKeyword = ","

    private val carNameList: List<String>

    init {
        val validatedCarNameString = getValidatedCarNameString(carName)
        carNameList = getCarNameByInput(validatedCarNameString)
    }

    fun getCarNameList(): List<String> = carNameList

    private fun getValidatedCarNameString(carNameList: String?): String {
        if (carNameList.isNullOrEmpty()) {
            throw EmptyOrNullableCarNameException()
        }

        return carNameList
    }

    private fun getCarNameByInput(carName: String): List<String> {
        return carName.split(splitKeyword).map { it.trim() }
    }
}