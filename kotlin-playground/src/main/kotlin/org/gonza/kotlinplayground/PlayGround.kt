package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.presentation.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.presentation.exception.InvalidTryCountException
import org.gonza.kotlinplayground.presentation.ui.InputView
import org.gonza.kotlinplayground.presentation.ui.InputViewImpl
import org.gonza.kotlinplayground.presentation.ui.OutputView
import org.gonza.kotlinplayground.presentation.ui.OutputViewImpl
import org.gonza.kotlinplayground.service.RandomMoveStrategy
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount

fun main() {
    val output = OutputViewImpl()
    val input = InputViewImpl()
    val moveStrategy = RandomMoveStrategy()
    val gameConfig = createGameConfig(output, input)

    val runner =
        RacingCarGameRunner(
            output = output,
            moveStrategy = moveStrategy,
        )

    runner.run(gameConfig)
}

private fun createGameConfig(
    output: OutputView,
    input: InputView,
): GameConfig {
    val carName = getValidCarName(output, input)
    val tryCount = getValidTryCount(output, input)
    return GameConfig(carName, tryCount)
}

private fun getValidCarName(
    output: OutputView,
    input: InputView,
): CarName {
    output.printInputCarNameListMessage()
    return try {
        val inputValue = input.read()
        CarName.from(inputValue)
    } catch (e: EmptyOrNullableCarNameException) {
        output.printEmptyOrNullCarNameError()
        getValidCarName(output, input)
    }
}

private fun getValidTryCount(
    output: OutputView,
    input: InputView,
): TryCount {
    output.printInputTryCountMessage()
    return try {
        val inputValue = input.read()
        TryCount.from(inputValue)
    } catch (e: InvalidTryCountException) {
        output.printTryCountError()
        getValidTryCount(output, input)
    }
}
