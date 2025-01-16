package org.gonza.kotlinplayground.view

import java.util.Scanner

class InputView {
    fun carNames(): String {
        val scanner = Scanner(System.`in`)
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return scanner.next()
    }

    fun racingCount(): Int {
        val scanner = Scanner(System.`in`)
        println("시도할 회수는 몇 회인가요?")
        return scanner.nextInt()
    }
}
