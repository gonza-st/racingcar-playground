package org.gonza.kotlinplayground

class Car(
    val name: String,
){
    init {
        require(name.isNotBlank()) { "이름은 비어있을 수 없다" }
    }

    private var _location: Int = 0
    val location: Int
        get() = _location
}
