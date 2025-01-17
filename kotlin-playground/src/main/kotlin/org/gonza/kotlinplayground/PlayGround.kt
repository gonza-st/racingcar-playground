package org.gonza.kotlinplayground

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
    return getValidatedTemplate(
        outputMessage = output::printInputCarNameList,
        inputMessage = input::read,
        errorMessage = output::printCarNameError,
        validator = validator::getValidatedCarName
    )
}

private fun getValidatedTryCount(
    output: OutputView,
    input: InputView,
    validator: RacingCarGameValidator
): Int {
    return getValidatedTemplate(
        outputMessage = output::printTryCount,
        inputMessage = input::read,
        errorMessage = output::printTryCountError,
        validator = validator::getValidatedTryCountString
    )
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
