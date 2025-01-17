package org.gonza.kotlinplayground.ui

interface OutputView {
    fun printInputCarNameListMessage()

    fun printInputTryCountMessage()

    fun printCarName(carName: String)

    fun printMovement(count: String)

    fun printResultMessage()

    fun printWinnerMessage(winner: String)

    fun printEmptyOrNullCarNameError()

    fun printDuplicatedCarNameError()

    fun printInvalidCarNameLengthError()

    fun printTryCountError()
}
