package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.vo.CarNameByInput
import org.gonza.kotlinplayground.vo.TryCountByInput

class RacingCarGame(
    carNameByInput: CarNameByInput,
    tryCountByInput: TryCountByInput
) {
    constructor(carNameByInput: CarNameByInput) : this(carNameByInput, TryCountByInput("1"))

    private val splitKeyword = ","

    private val carNameList: List<String>

    init {
        val validatedCarNameString = getValidatedCarNameString(carNameByInput.value)
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