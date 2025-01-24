package org.gonza.kotlinplayground.view

class OutputView {
    fun result(value: List<String>) {
        println("실행 결과")
        value.forEach { println(it) }
    }

    fun winner(value: String) {
        println("${value}가 최종 우승했습니다.")
    }

    fun print(value: String) {
        println(value)
    }
}
