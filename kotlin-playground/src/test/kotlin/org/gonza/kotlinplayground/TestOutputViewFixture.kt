package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.OutputView

class TestOutputViewFixture : OutputView {
    var printErrorCount = 0

    override fun printInputCarNameListMessage() {
    }

    override fun printInputTryCountMessage() {
    }

    override fun printCarName(carName: String) {
        TODO("Not yet implemented")
    }

    override fun printMovement(count: String) {
        TODO("Not yet implemented")
    }

    override fun printResultMessage() {
        TODO("Not yet implemented")
    }

    override fun printWinnerMessage(winner: String) {
        TODO("Not yet implemented")
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
}
