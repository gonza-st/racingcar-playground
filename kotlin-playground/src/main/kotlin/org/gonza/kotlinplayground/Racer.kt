package org.gonza.kotlinplayground

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
