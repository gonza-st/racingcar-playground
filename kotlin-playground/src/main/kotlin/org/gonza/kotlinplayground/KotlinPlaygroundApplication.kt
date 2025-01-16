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

    val carNames: String = input.carNames()
    val racingCount: Int = input.racingCount()

    val race =
        Race(
            carNames = carNames,
            raceTimes = racingCount,
            numberGenerator = RandomNumberGenerator(),
        )

    race.run()

    output.roundPosition(race.raceResult())
    output.winner(race.raceResult())
}
