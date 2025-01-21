package org.gonza.kotlinplayground.racer

import org.gonza.kotlinplayground.car.Accelerate
import org.gonza.kotlinplayground.car.Car
import org.gonza.kotlinplayground.car.Motion

class Racer(
    val car: Car,
    private val accelerate: Accelerate
) {
    fun race() {
        if(accelerate.press() == Motion.MOVE){
            car.move()
        }
    }
}
