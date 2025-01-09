package org.gonza.kotlinplayground.ui

class PrintView private constructor(){

    fun print(message: String) {
        println(message)
    }

    companion object {
        private var instance: PrintView? = null

        fun getInstance(): PrintView {
            return instance ?: PrintView().apply {
                instance = this
            }
        }
    }
}