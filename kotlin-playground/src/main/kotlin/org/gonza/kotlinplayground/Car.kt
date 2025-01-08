package org.gonza.kotlinplayground

class Car(
    val name: String,
    val location: Int
){
    init {
        require(name.isNotBlank()) { "이름은 비어있을 수 없다" }
        require(location >= 0) { "위치는 음수일 수 없다" }
    }
}
