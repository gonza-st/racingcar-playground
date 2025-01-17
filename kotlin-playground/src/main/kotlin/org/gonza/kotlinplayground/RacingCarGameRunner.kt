package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException
import org.gonza.kotlinplayground.dto.GameResult
import org.gonza.kotlinplayground.dto.toRacingCarGame
import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.OutputView
import org.gonza.kotlinplayground.ui.exception.EmptyOrNullableCarNameException
import org.gonza.kotlinplayground.ui.exception.InvalidTryCountException
import org.gonza.kotlinplayground.vo.CarName
import org.gonza.kotlinplayground.vo.TryCount

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
        } catch (e: InvalidCarNameLengthException) {
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

    private fun getValidGame(carName: CarName): RacingCarGame {
        try {
            return RacingCarGame(carName = carName)
        } catch (e: DuplicatedCarNameException) {
            output.printDuplicatedCarNameError()
            throw e
        } catch (e: InvalidCarNameLengthException) {
            output.printInvalidCarNameLengthError()
            throw e
        }
    }

    private fun startGame(config: GameConfig) {
        var racingCarGame = getValidGame(config.carName)
        output.printResultMessage()

        while (!racingCarGame.isFinished(config.tryCount)) {
            val result = playRound(racingCarGame)
            racingCarGame = result.toRacingCarGame()
        }

        val winner = racingCarGame.findWinner()
        printWinner(winner)
    }

    private fun playRound(game: RacingCarGame): GameResult {
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

    private data class GameConfig(
        val carName: CarName,
        val tryCount: TryCount
    )
}

