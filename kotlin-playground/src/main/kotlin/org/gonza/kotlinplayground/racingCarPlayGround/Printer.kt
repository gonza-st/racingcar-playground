package org.gonza.kotlinplayground.racingCarPlayGround

class Printer {
    fun printCar(car: Car) {
        println("${car.displayName()} : ${"-".repeat(car.displayPosition())}")
    }
}