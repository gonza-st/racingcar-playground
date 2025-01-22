package org.gonza.kotlinplayground.presentation.ui

class InputViewImpl : InputView {
    override fun read(): String? = readlnOrNull()
}
