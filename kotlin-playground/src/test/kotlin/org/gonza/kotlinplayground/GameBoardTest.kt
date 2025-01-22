package org.gonza.kotlinplayground

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.gonza.kotlinplayground.dto.RaceParticipants

class GameBoardTest :
    BehaviorSpec({
        val commaCars = "우진,희진,희찬,희수,희준"
        Given("참가 자동차, 룰, 라운드가 주어졌을 때") {
            val raceParticipants = RaceParticipants(commaCars)
            val strategy = RandomMoveStrategy()
            When("게임보드를 생성하면") {
                val gameBoard =
                    GameBoard(
                        raceParticipants = raceParticipants,
                        strategy = strategy,
                    )

                Then("설정된 수의 자동차가 존재해야 한다") {
                    gameBoard.raceParticipants.cars.size shouldBe 5
                }

                Then("모든 자동차의 초기 위치는 1이어야 한다") {
                    gameBoard.raceParticipants.cars.all { it.position == 1 } shouldBe true
                }

                Then("설정한 이동 전략이 적용되어 있어야 한다") {
                    gameBoard.strategy shouldBe strategy
                }
            }
        }
        Given("항상 이동하는 전략이 주어졌을 때") {
            val raceParticipants = RaceParticipants(commaCars)
            val alwaysMoveStrategy =
                object : MoveStrategy {
                    override fun determineNextMove(): Int = 1
                }
            When("게임을 진행하면") {
                val gameBoard =
                    GameBoard(
                        raceParticipants = raceParticipants,
                        strategy = alwaysMoveStrategy,
                    )
                gameBoard.run()

                Then("모든 자동차의 위치가 2가 되어야 한다") {
                    val cars = gameBoard.raceParticipants.cars
                    cars.forEach { car ->
                        car.position shouldBe 2
                    }
                }

                Then("어떤 자동차도 초기 위치(1)에 있으면 안 된다") {
                    raceParticipants.cars.none { car ->
                        car.position == 1
                    } shouldBe true
                }
            }
        }
    })
