package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.car.Car
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.domain.car.RacingCars
import org.gonza.kotlinplayground.presentation.ui.OutputView
import org.gonza.kotlinplayground.service.Round
import org.gonza.kotlinplayground.service.dto.GameResult
import org.gonza.kotlinplayground.service.dto.toRound
import org.gonza.kotlinplayground.service.vo.CarName
import org.gonza.kotlinplayground.util.CarNameParser

class RacingCarGameRunner(
    private val output: OutputView,
    private val moveStrategy: MoveStrategy,
) {
    fun run(gameConfig: GameConfig) {
        startGame(gameConfig)
    }

    private fun startGame(config: GameConfig) {
        val carNameList =
            org.gonza.kotlinplayground.util.CarNameParser
                .parse(config.carName)
        val carList = CarNameConverter.toCarList(carNameList)
        val racingCars = RacingCars(carList)
        var round = Round(racingCars)
        output.printResultMessage()

        while (!round.isFinished(config.tryCount)) {
            val result = playRound(round)
            round = result.toRound()
        }

        val winner = round.findWinner()
        val winnerCarNameList = CarNameParser.toCarNameString(winner)
        printWinner(winnerCarNameList)
    }

    private fun playRound(round: Round): GameResult {
        val result = round.start(moveStrategy)
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

    private object CarNameParser {
        private const val SPLIT_KEYWORD = ","

        fun toCarNameString(carNameList: List<CarName>): String = carNameList.joinToString(SPLIT_KEYWORD) { it.value }
    }

    private object CarNameConverter {
        fun toCarList(carNameList: List<CarName>): List<Car> = carNameList.map { Car(it.value, 0) }
    }
}
