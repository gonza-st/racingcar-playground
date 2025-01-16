package org.gonza.kotlinplayground.dto

data class Car(
    val name: String,
) {
    init {
        require(name.isNotEmpty()) { "자동차 이름을 입력해주세요." }
        require(name.isNotBlank()) { "공백으로만 이루어진 이름이 존재합니다." } // isBlank()가 아닌 !isBlank()
        require(name.length <= 5) { "자동차 이름은 5자 이하여야 합니다." }
    }

    var position: Int = 1
        private set

    fun moveForward(moveCount: Int) {
        position += moveCount
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Car) return false
        return name == other.name
    }

    override fun hashCode(): Int = name.hashCode()
}
