package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.dto.Car
import org.gonza.kotlinplayground.dto.RaceParticipants

class RacingGameUI {
    fun start() {
        while (true) {
            val raceParticipants = inputParticipants()
            val tryCount = inputTryCount()
            val gameBoard = GameBoard(raceParticipants, RandomMoveStrategy())
            println("\n실행 결과")
            outputRoundResult(raceParticipants.cars)
            repeat(tryCount) {
                Thread.sleep(1000)
                gameBoard.run()
                val cars = gameBoard.raceParticipants.cars
                outputRoundResult(cars)
            }
            outputWinner(gameBoard.raceParticipants.cars)
        }
    }

    private fun outputWinner(cars: List<Car>) {
        val winners =
            cars.filter { car ->
                car.position == cars.maxOf { it.position }
            }
        val winnerNames = winners.joinToString(", ") { it.name }
        println("$winnerNames 이(가) 최종 우승했습니다.\n")
    }

    private fun outputRoundResult(cars: List<Car>) {
        val roundResult =
            cars.map {
                "${it.name}: ${"-".repeat(it.position)}"
            }
        println(roundResult.joinToString("\n"))
        println()
    }

    private fun inputParticipants(): RaceParticipants {
        while (true) {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
            val input = readlnOrNull() ?: continue
            try {
                return RaceParticipants(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputTryCount(): Int {
        while (true) {
            println("시도할 회수는 몇회인가요?")
            val input = readlnOrNull() ?: continue

            try {
                return input.toInt().also { count ->
                    require(count > 0) { "시도 횟수는 1 이상이어야 합니다." }
                }
            } catch (e: NumberFormatException) {
                println("시도 횟수는 숫자로 입력해주세요.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
