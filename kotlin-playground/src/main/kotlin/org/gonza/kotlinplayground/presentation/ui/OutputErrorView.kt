package org.gonza.kotlinplayground.presentation.ui

interface OutputErrorView {
    fun printEmptyOrNullCarNameError()

    fun printDuplicatedCarNameError()

    fun printInvalidCarNameLengthError()

    fun printTryCountError()
}
