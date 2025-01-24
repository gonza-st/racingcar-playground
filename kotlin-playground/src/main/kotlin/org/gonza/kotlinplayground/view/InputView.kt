package org.gonza.kotlinplayground.view

import java.util.Scanner

class InputView {
    fun string(): String {
        val scanner = Scanner(System.`in`)
        return scanner.next()
    }

    fun int(): Int {
        val scanner = Scanner(System.`in`)
        return scanner.nextInt()
    }
}
