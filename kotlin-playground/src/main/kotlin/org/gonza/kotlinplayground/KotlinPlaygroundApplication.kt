package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.car.Accelerate
import org.gonza.kotlinplayground.car.Car
import org.gonza.kotlinplayground.game.Racing
import org.gonza.kotlinplayground.racer.Racer
import org.gonza.kotlinplayground.racer.Racers
import org.gonza.kotlinplayground.rule.Judge
import org.gonza.kotlinplayground.rule.NumberGeneratorImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPlaygroundApplication

fun main(args: Array<String>) {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carNames = readln()

    println("시도할 회수는 몇회인가요?")
    val attempts = readln().toInt()

    val racers = createRacers(carNames)
    val judge = Judge()
    val game = Racing(racers, judge)

    println("\n실행 결과")
    game.play(attempts)
}
private fun createRacers(input: String): Racers {
    require(input.isNotBlank()) { "자동차 이름을 입력해주세요." }

    val names = input.split(",").map { it.trim() }
    require(names.isNotEmpty()) { "최소 하나의 자동차 이름이 필요합니다." }

    val racers = names.map { name ->
        val car = Car(name)
        val accelerate = Accelerate(NumberGeneratorImpl())
        Racer(car, accelerate)
    }
    return Racers(racers)
}