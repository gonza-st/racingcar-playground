package org.gonza.kotlinplayground.racingCarPlayGround

class Car private constructor(
        private val name: String,
        private val position: Int = 0
) {
    companion object {
        const val MOVING_POSITION = 1

        fun create(name: String, position: Int = 0): Car {
            return Car(name, position)
        }
    }

    init {
        require(name.isNotBlank()) { "차 이름이 빈 문자열이거나 공백만 있으면 에러가 발생한다" }
        require(name.length <= 5) { "차 이름은 5자 이하여야 한다" }
        require(position >= 0) { "차 위치는 0 이상이어야 한다" }
    }

    fun move(): Car = Car(name, position + MOVING_POSITION)

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    fun comparePositionWith(other: Car): Int {
        return this.position.compareTo(other.position)
    }

    fun isSameName(name: String): Boolean {
        return this.name == name
    }

    fun displayName(): String {
        return name
    }

    fun displayPosition(): Int {
        return position
    }
}

