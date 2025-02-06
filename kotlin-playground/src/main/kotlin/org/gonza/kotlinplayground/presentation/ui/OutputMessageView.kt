package org.gonza.kotlinplayground.presentation.ui

interface OutputMessageView {
    fun printInputCarNameListMessage()

    fun printInputTryCountMessage()

    fun printCarName(carName: String)

    fun printMovement(count: Int)

    fun printResultMessage()

    fun printWinnerMessage(winner: String)

    fun println()
}
