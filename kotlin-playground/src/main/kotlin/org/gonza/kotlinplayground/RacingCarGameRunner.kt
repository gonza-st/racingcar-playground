package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException
import org.gonza.kotlinplayground.presentation.RacingCarGameValidator
import org.gonza.kotlinplayground.presentation.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.presentation.exception.InvalidTryCountException
import org.gonza.kotlinplayground.presentation.ui.InputView
import org.gonza.kotlinplayground.presentation.ui.OutputView
import org.gonza.kotlinplayground.service.Round
import org.gonza.kotlinplayground.service.dto.GameResult
import org.gonza.kotlinplayground.service.dto.toRacingCarGame
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.service.vo.TryCount

class RacingCarGameRunner(
    private val output: OutputView,
    private val input: InputView,
    private val validator: RacingCarGameValidator,
    private val moveStrategy: MoveStrategy,
) {
    fun run() {
        try {
            val gameConfig = createGameConfig()
            startGame(gameConfig)
        } catch (e: DuplicatedCarNameException) {
            run()
        }
    }

    private fun createGameConfig(): GameConfig {
        val carName = getValidCarName()
        val tryCount = getValidTryCount()
        return GameConfig(carName, tryCount)
    }

    private fun getValidCarName(): CarName {
        output.printInputCarNameListMessage()
        return try {
            val inputValue = input.read()
            CarName(validator.getValidatedCarName(inputValue))
        } catch (e: EmptyOrNullableCarNameException) {
            output.printEmptyOrNullCarNameError()
            getValidCarName()
        }
    }

    private fun getValidTryCount(): TryCount {
        output.printInputTryCountMessage()
        return try {
            val inputValue = input.read()
            TryCount(validator.getValidatedTryCountString(inputValue))
        } catch (e: InvalidTryCountException) {
            output.printTryCountError()
            getValidTryCount()
        }
    }

    private fun getValidRound(carName: CarName): Round {
        try {
            return Round(carName = carName)
        } catch (e: DuplicatedCarNameException) {
            output.printDuplicatedCarNameError()
            throw e
        } catch (e: InvalidCarNameLengthException) {
            output.printInvalidCarNameLengthError()
            throw e
        }
    }

    private fun startGame(config: GameConfig) {
        var round = getValidRound(config.carName)
        output.printResultMessage()

        while (!round.isFinished(config.tryCount)) {
            val result = playRound(round)
            round = result.toRacingCarGame()
        }

        val winner = round.findWinner()
        printWinner(winner)
    }

    private fun playRound(game: Round): GameResult {
        val result = game.start(moveStrategy)
        printRoundInfo(result.movedCarList)
        return result
    }

    private fun printRoundInfo(carList: List<Car>) {
        output.println()
        carList.forEach { car ->
            output.printCarName(car.getName())
            output.printMovement(car.getPosition())
            output.println()
        }
    }

    private fun printWinner(winner: String) {
        output.printWinnerMessage(winner)
    }
}
