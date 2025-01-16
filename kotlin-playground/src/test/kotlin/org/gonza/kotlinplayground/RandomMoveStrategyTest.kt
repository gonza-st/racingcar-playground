package org.gonza.kotlinplayground

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn

class RandomMoveStrategyTest :
    BehaviorSpec({

        Given("랜덤 이동 전략을 생성하고") {
            val randomMoveStrategy = RandomMoveStrategy()
            When("다음 이동 칸을 결정하면") {
                val move = randomMoveStrategy.determineNextMove()
                Then("다음 이동 여부가 0 또는 1이어야 한다") {
                    move shouldBeIn listOf(0, 1)
                }
            }
        }
    })
