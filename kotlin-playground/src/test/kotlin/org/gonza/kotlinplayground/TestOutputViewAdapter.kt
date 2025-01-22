package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.presentation.ui.OutputErrorView
import org.gonza.kotlinplayground.presentation.ui.OutputView

class TestOutputViewAdapter(private val errorView: OutputErrorView) : OutputView {
    override fun printInputCarNameListMessage() {}
    override fun printInputTryCountMessage() {}
    override fun printCarName(carName: String) {}
    override fun printMovement(count: Int) {}
    override fun printResultMessage() {}
    override fun printWinnerMessage(winner: String) {}
    override fun println() {}

    override fun printEmptyOrNullCarNameError() {
        errorView.printEmptyOrNullCarNameError()
    }

    override fun printDuplicatedCarNameError() {
        errorView.printDuplicatedCarNameError()
    }

    override fun printInvalidCarNameLengthError() {
        errorView.printInvalidCarNameLengthError()
    }

    override fun printTryCountError() {
        errorView.printTryCountError()
    }
}
