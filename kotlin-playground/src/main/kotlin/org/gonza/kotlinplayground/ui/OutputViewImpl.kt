package org.gonza.kotlinplayground.ui

class OutputViewImpl : OutputView {
    override fun printInputCarNameList() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    override fun printTryCount() {
        println("시도할 회수는 몇회인가요?")
    }

    override fun printEmptyOrNullCarNameError() {
        println("차량 이름을 잘 못 입력하였습니다.")
    }

    override fun printDuplicatedCarNameError() {
        println("차량 이름은 중복될 수 없습니다.")
    }

    override fun printInvalidCarNameLengthError() {
        println("차량 이름은 5글자를 초과할 수 없습니다.")
    }

    override fun printTryCountError() {
        println("시도 횟수를 잘 못 입력하였습니다.")
    }
}
