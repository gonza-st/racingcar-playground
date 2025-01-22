package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.dto.Car
import org.gonza.kotlinplayground.dto.RaceParticipants

class RacingGameUI {
    fun start() {
        while (true) {
            val raceParticipants = inputParticipants()
            val tryCount = inputTryCount()
            val gameBoard = GameBoard(raceParticipants, RandomMoveStrategy())
            println("-".repeat(50))
            println("실행 결과")
            outputRoundResult(raceParticipants.cars)
            repeat(tryCount) {
                Thread.sleep(1000)
                gameBoard.run()
                val cars = gameBoard.raceParticipants.cars
                outputRoundResult(cars)
            }
            outputWinner(gameBoard.raceParticipants.cars)
            println("-".repeat(50))
            val isContinue = outputIsContinue()
            if (!isContinue) {
                break
            }
        }
    }

    // 게임 종료 여부를 묻고, 종료하면 종료 메시지 출력
    private fun outputIsContinue(): Boolean {
        while (true) {
            try {
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                val input = readlnOrNull() ?: continue
                when (input) {
                    "1" -> return true
                    "2" -> {
                        println("게임을 종료합니다.")
                        return false
                    }
                    else -> throw Exception()
                }
            } catch (e: Exception) {
                println("1 또는 2를 입력해주세요.")
            }
        }
    }

    private fun outputWinner(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.position }
        val winners =
            cars.filter { car ->
                car.position == maxPosition
            }
        val winnerNames = winners.joinToString(", ") { it.name }
        println("$winnerNames 이(가) 최종 우승했습니다.")
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
