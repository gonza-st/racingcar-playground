package org.gonza.kotlinplayground.ui

interface OutputView {
    fun printInputCarNameList()

    fun printTryCount()

    fun printEmptyOrNullCarNameError()

    fun printDuplicatedCarNameError()

    fun printInvalidCarNameLengthError()

    fun printTryCountError()
}
