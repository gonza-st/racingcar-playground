package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.exception.DuplicatedCarNameException
import org.gonza.kotlinplayground.domain.car.exception.InvalidCarNameLengthException
import org.gonza.kotlinplayground.presentation.ui.OutputView
import org.gonza.kotlinplayground.service.Round
import org.gonza.kotlinplayground.service.dto.GameResult
import org.gonza.kotlinplayground.service.dto.toRound
import org.gonza.kotlinplayground.service.vo.CarName

class RacingCarGameRunner(
    private val output: OutputView,
    private val moveStrategy: MoveStrategy,
) {
    fun run(gameConfig: GameConfig) {
        startGame(gameConfig)
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
            round = result.toRound()
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
            output.printCarName(car.name)
            output.printMovement(car.position)
            output.println()
        }
    }

    private fun printWinner(winner: String) {
        output.printWinnerMessage(winner)
    }
}
