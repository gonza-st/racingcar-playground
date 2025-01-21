package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.racingCarPlayGround.Cars
import org.gonza.kotlinplayground.racingCarPlayGround.RacingController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<KotlinPlaygroundApplication>(*args)

    val cars = Cars.fromString("taxi,bus,bike")
    val racing = RacingController(cars = cars, round = 6)
    racing.playRace()
}
