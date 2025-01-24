package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.domain.Race
import org.gonza.kotlinplayground.domain.RandomNumberGenerator
import org.gonza.kotlinplayground.view.InputView
import org.gonza.kotlinplayground.view.OutputView
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<KotlinPlaygroundApplication>(*args)
    val input = InputView()
    val output = OutputView()

    output.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carNames: String = input.string()
    output.print("시도할 회수는 몇 회인가요?")
    val racingCount: Int = input.int()

    val race =
        Race(
            carNames = carNames,
            raceTimes = racingCount,
            numberGenerator = RandomNumberGenerator(),
        )

    race.run()

    output.result(race.raceResult)
    output.winner(race.raceWinners)
}
