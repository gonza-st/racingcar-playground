package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.OutputView

fun main() {
    val output = OutputView()
    val input = InputView()

    output.printInputCarNameList()
    val carName = input.read()
    output.printTryCount()
    val tryCount = input.read()
}
