package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.PrintView
import org.gonza.kotlinplayground.utils.Validator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPlaygroundApplication

fun main() {
    val inputView = InputView.getInstance()
    val printView = PrintView.getInstance()
    val validator = Validator()

    printView.print(RacingConstants.USER_INPUT_CAR_NAME_HELP)
    val carNameStr =  inputView.input()
    validator.validateDelimiter(carNameStr)

    printView.print(RacingConstants.USER_INPUT_COUNT_HELP)
}
