package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.OutputView
import org.gonza.kotlinplayground.vo.CarName
import org.gonza.kotlinplayground.vo.TryCount

fun main() {
    val output = OutputView()
    val input = InputView()
    val validator = RacingCarGameValidator()

    val carNameByInput = getValidatedCarName(output, input, validator)
    val tryCountByInput = getValidatedTryCount(output, input, validator)
    val racingCarGame = RacingCarGame(
        carName = carNameByInput,
    )
}

private fun getValidatedCarName(
    output: OutputView,
    input: InputView,
    validator: RacingCarGameValidator
): CarName {
    val value = getValidatedTemplate(
        outputMessage = output::printInputCarNameList,
        inputMessage = input::read,
        errorMessage = output::printCarNameError,
        validator = validator::getValidatedCarName
    )

    return CarName(value)
}

private fun getValidatedTryCount(
    output: OutputView,
    input: InputView,
    validator: RacingCarGameValidator
): TryCount {
    val value = getValidatedTemplate(
        outputMessage = output::printTryCount,
        inputMessage = input::read,
        errorMessage = output::printTryCountError,
        validator = validator::getValidatedTryCountString
    )

    return TryCount(value)
}

private fun <T> getValidatedTemplate(
    outputMessage: () -> Unit,
    inputMessage: () -> String?,
    errorMessage: () -> Unit,
    validator: (String?) -> T,
): T {
    try {
        outputMessage()
        val inputValue = inputMessage()
        return validator(inputValue)
    } catch (e: Exception) {
        errorMessage()
        return getValidatedTemplate(
            outputMessage = outputMessage,
            inputMessage = inputMessage,
            errorMessage = errorMessage,
            validator = validator
        )
    }
}
