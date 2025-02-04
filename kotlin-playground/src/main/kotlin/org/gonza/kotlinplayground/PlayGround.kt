package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.presentation.ui.InputViewImpl
import org.gonza.kotlinplayground.presentation.ui.OutputViewImpl
import org.gonza.kotlinplayground.service.RandomMoveStrategy

fun main() {
    val runner =
        RacingCarGameRunner(
            output = OutputViewImpl(),
            input = InputViewImpl(),
            moveStrategy = RandomMoveStrategy(),
        )

    runner.run()
}
