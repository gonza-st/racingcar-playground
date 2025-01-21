package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.car.Car

object Fixture {
    const val name = "지바겐"
    const val location: Int = 0

    val car = Car(name = name)
}