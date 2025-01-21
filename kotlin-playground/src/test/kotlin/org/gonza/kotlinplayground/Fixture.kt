package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.car.Accelerate
import org.gonza.kotlinplayground.car.Car
import org.gonza.kotlinplayground.racer.Racer
import org.gonza.kotlinplayground.rule.FakeNumberGeneratorImpl

object Fixture {
    const val name = "지바겐"
    const val location: Int = 0

    val car = Car(name = name)

    val racer1 = createRacer(
        name = "에이바겐",
        number = 1
    )

    val racer2 = createRacer(
        name = "비바겐",
        number = 5
    )

    fun createRacer(name: String, number: Int): Racer{
       return Racer(
           car = Car(name = name),
           accelerate = Accelerate(FakeNumberGeneratorImpl(number))
       )
    }
}