package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.OutputView

class TestOutputViewFixture : OutputView {
    var printErrorCount = 0

    override fun printInputCarNameListMessage() {
    }

    override fun printInputTryCountMessage() {
    }

    override fun printCarName(carName: String) {
    }

    override fun printMovement(count: Int) {
    }

    override fun printResultMessage() {
    }

    override fun printWinnerMessage(winner: String) {
    }

    override fun printEmptyOrNullCarNameError() {
        printErrorCount++
    }

    override fun printDuplicatedCarNameError() {
        printErrorCount++
    }

    override fun printInvalidCarNameLengthError() {
        printErrorCount++
    }

    override fun printTryCountError() {
        printErrorCount++
    }

    override fun println() {
    }
}
