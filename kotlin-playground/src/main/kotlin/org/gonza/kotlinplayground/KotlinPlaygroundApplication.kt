package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.ui.InputView
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPlaygroundApplication

fun main() {
    val inputView = InputView.getInstance()

}
