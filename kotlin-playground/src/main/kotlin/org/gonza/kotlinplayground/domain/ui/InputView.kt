package org.gonza.kotlinplayground.domain.ui

class InputView {
    fun read(): String? = readlnOrNull()
}