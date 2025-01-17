package org.gonza.kotlinplayground.ui

class InputViewImpl : InputView {
    override fun read(): String? = readlnOrNull()
}
