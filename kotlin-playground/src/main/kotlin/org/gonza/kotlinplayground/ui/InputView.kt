package org.gonza.kotlinplayground.ui

class InputView private constructor(){

    fun input(): String {
        val answer = readlnOrNull().orEmpty()

        return answer
    }

    companion object {
        private var instance: InputView? = null

        fun getInstance(): InputView {
            return instance ?: InputView().apply {
                instance = this
            }
        }
    }
}