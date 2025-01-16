package org.gonza.kotlinplayground

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.gonza.kotlinplayground.dto.RaceParticipants
import org.junit.jupiter.api.assertThrows

class RaceParticipantsTest :
    BehaviorSpec({

        Given(",로 이루어진 문자열이 주어졌을 때") {
            When("중복된 차량이 주어지면") {
                val duplicatedCars =
                    "우진,희진,희찬,희수,희준,우진"
                Then("중복된 차량이 존재할 수 없다.") {
                    assertThrows<IllegalArgumentException> {
                        RaceParticipants(duplicatedCars)
                    }
                }
            }
            When("중복되지 않은 차량이 주어지면") {
                val commaString = "우진,희진,희찬,희수,희준"
                val raceParticipants = RaceParticipants(commaString)
                Then("RaceParticipants 객체가 생성된다.") {
                    raceParticipants.cars.size shouldBe 5
                }
            }
        }
    })
