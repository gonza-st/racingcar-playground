package org.gonza.kotlinplayground.domain.ui

class OutputView {
    fun printInputCarNameList() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printTryCount() {
        println("시도할 회수는 몇회인가요?")
    }

    fun printCarNameError() {
        println("차량 이름을 잘 못 입력하였습니다.")
    }

    fun printTryCountError() {
        println("시도 횟수를 잘 못 입력하였습니다.")
    }
}