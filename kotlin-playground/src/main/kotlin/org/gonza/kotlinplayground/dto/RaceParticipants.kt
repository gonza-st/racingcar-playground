package org.gonza.kotlinplayground.dto

data class RaceParticipants(
    private val commaString: String,
) {
    init {
        require(!commaString.endsWith(",")) { "입력값이 콤마로 끝날 수 없습니다." }
    }

    val cars: List<Car> = parseAndValidateInput(commaString)

    private fun parseAndValidateInput(input: String): List<Car> {
        val names = splitName(input)
        return names
            .map { Car(it) }
            .also { validateCars(it) }
    }

    private fun splitName(input: String) = input.split(",")

    private fun validateCars(cars: List<Car>) {
        require(!hasDuplicatedCar(cars)) { "중복된 자동차가 존재합니다." }
    }

    private fun hasDuplicatedCar(cars: List<Car>): Boolean = cars.toSet().size != cars.size
}
