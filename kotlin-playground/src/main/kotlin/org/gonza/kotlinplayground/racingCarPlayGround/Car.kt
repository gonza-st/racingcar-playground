package org.gonza.kotlinplayground.racingCarPlayGround

class Car(val name: String, val position: Int = 0) {
    companion object {
        const val MOVING_POSITION = 1
    }

    init {
        require(name.isNotBlank()) { "차 이름이 빈 문자열이거나 공백만 있으면 에러가 발생한다" }
        require(name.length <= 5) { "차 이름은 5자 이하여야 한다" }
        require(position >= 0) { "차 위치는 0 이상이어야 한다" }
    }

    fun move(): Car = Car(name, position + MOVING_POSITION)

    fun printCar() {
        println("$name : ${"-".repeat(position)}")
    }
}

