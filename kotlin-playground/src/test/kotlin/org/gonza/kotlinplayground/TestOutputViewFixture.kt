package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.OutputView

class TestOutputViewFixture : OutputView {
    var printErrorCount = 0

    override fun printInputCarNameList() {
    }

    override fun printTryCount() {
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
