package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.OutputView

fun main() {
    val output = OutputView()
    val input = InputView()
    val validator = RacingCarGameValidator()

    val carNameByInput = getValidatedCarName(output, input, validator)
    val tryCount = getValidatedTryCount(output, input, validator)
}

private fun getValidatedCarName(
    output: OutputView,
    input: InputView,
    validator: RacingCarGameValidator
): String {
    while (true) {
        try {
            output.printInputCarNameList()
            val carNameByInput = input.read()
            return validator.getValidatedCarName(carNameByInput)
        } catch (e: EmptyOrNullableCarNameException) {
            output.printCarNameError()
        }
    }
}

private fun getValidatedTryCount(
    output: OutputView,
    input: InputView,
    validator: RacingCarGameValidator
): Int {
    while (true) {
        try {
            output.printTryCount()
            val tryCountByInput = input.read()
            return validator.getValidatedTryCountString(tryCountByInput)
        } catch (e: EmptyOrNullableCarNameException) {
            output.printTryCount()
        }
    }
}
