package org.gonza.kotlinplayground.ui

interface OutputErrorView {
    fun printEmptyOrNullCarNameError()

    fun printDuplicatedCarNameError()

    fun printInvalidCarNameLengthError()

    fun printTryCountError()
}
