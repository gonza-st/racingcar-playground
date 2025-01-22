package org.gonza.kotlinplayground

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.gonza.kotlinplayground.dto.Car
import org.junit.jupiter.api.assertThrows

class CarTest :
    BehaviorSpec({
        val position = 1
        Given("이름이 우진인 자동차가 주어졌을때") {
            val carName = "우진"
            When("자동차를 생성하면") {
                val car = Car(carName)

                Then("생성된 자동차의 이름은 우진이고 위치는 1이다") {
                    car.name shouldBe carName
                    car.position shouldBe position
                }
            }
            When("자동차를 생성하고 1칸 전진하면") {
                val car = Car(carName)
                val moveCount = 1
                car.moveForward(moveCount)
                Then("생성된 자동차의 이름은 우진이고 위치는 1 증가한다.") {
                    car.name shouldBe carName
                    car.position shouldBe position + moveCount
                }
            }
        }
        Given("이름이 빈 문자열인 자동차가 주어졌을때") {
            val carName = ""
            When("자동차를 생성하면") {
                Then("자동차 이름을 입력해주세요. 예외가 발생한다.") {
                    assertThrows<IllegalArgumentException> {
                        Car(carName)
                    }
                }
            }
        }
        Given("이름이 공백으로만 이루어진 자동차가 주어졌을때") {
            val carName = " "
            When("자동차를 생성하면") {
                Then("공백으로만 이루어진 이름이 존재합니다. 예외가 발생한다.") {
                    assertThrows<IllegalArgumentException> {
                        Car(carName)
                    }
                }
            }
        }
        Given("이름이 6자 이상인 자동차가 주어졌을때") {
            val carName = "우진우진진진"
            When("자동차를 생성하면") {
                Then("자동차 이름은 5자 이하여야 합니다. 예외가 발생한다.") {
                    assertThrows<IllegalArgumentException> {
                        Car(carName)
                    }
                }
            }
        }
    })
