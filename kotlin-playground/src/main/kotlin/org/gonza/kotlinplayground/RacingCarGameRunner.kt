package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException
import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.OutputView
import org.gonza.kotlinplayground.ui.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.vo.CarName
import org.gonza.kotlinplayground.vo.TryCount

class RacingCarGameRunner(
    private val output: OutputView,
    private val input: InputView,
    private val validator: RacingCarGameValidator,
    private val moveStrategy: MoveStrategy,
) {
    fun run() {
        val carName = getValidatedCarName()
        val tryCount = getValidatedTryCount()
        runGame(carName, tryCount)
    }

    private fun runGame(carName: CarName, tryCount: TryCount) {
        try {
            val racingCarGame = RacingCarGame(carName = carName)
            racingCarGame.start(moveStrategy)
        } catch (e: DuplicatedCarNameException) {
            output.printDuplicatedCarNameError()
            run()
        } catch (e: InvalidCarNameLengthException) {
            output.printInvalidCarNameLengthError()
            run()
        }
    }

    private fun getValidatedCarName(): CarName {
        output.printInputCarNameList()
        return try {
            val inputValue = input.read()
            CarName(validator.getValidatedCarName(inputValue))
        } catch (e: EmptyOrNullableCarNameException) {
            output.printEmptyOrNullCarNameError()
            getValidatedCarName()
        }
    }

    private fun getValidatedTryCount(): TryCount {
        output.printTryCount()
        return try {
            val inputValue = input.read()
            TryCount(validator.getValidatedTryCountString(inputValue))
        } catch (e: Exception) {
            output.printTryCountError()
            getValidatedTryCount()
        }
    }
}
