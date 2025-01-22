package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.service.RandomMoveStrategy
import org.gonza.kotlinplayground.ui.InputViewImpl
import org.gonza.kotlinplayground.ui.OutputViewImpl

fun main() {
    val runner = RacingCarGameRunner(
        output = OutputViewImpl(),
        input = InputViewImpl(),
        validator = RacingCarGameValidator(),
        moveStrategy = RandomMoveStrategy()
    )

    runner.run()
}
