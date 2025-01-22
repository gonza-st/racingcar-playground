package org.gonza.kotlinplayground.presentation.ui

class TestOutputErrorView : OutputErrorView {
    var printErrorCount = 0

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
