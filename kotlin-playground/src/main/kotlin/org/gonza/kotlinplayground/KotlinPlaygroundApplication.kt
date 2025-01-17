package org.gonza.kotlinplayground

import org.gonza.kotlinplayground.config.RacingConstants
import org.gonza.kotlinplayground.domain.Car
import org.gonza.kotlinplayground.domain.Cars
import org.gonza.kotlinplayground.domain.Ranking
import org.gonza.kotlinplayground.domain.Track
import org.gonza.kotlinplayground.ui.InputView
import org.gonza.kotlinplayground.ui.PrintView
import org.gonza.kotlinplayground.utils.NumberGenerator
import org.gonza.kotlinplayground.utils.StringGenerator
import org.gonza.kotlinplayground.utils.Validator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPlaygroundApplication

fun main() {
    val inputView = InputView.getInstance()
    val printView = PrintView.getInstance()
    val validator = Validator()
    val numberGenerator = NumberGenerator()
    val stringGenerator = StringGenerator()

    printView.print(message = RacingConstants.USER_INPUT_CAR_NAME_HELP)
    val carNameStr = inputView.input()
    validator.validateDelimiter(target = carNameStr)
    val carNameList = stringGenerator.generate(carNameStr)
    val carList = carNameList.map { name ->
        Car(
            name = name,
            validator = validator,
            generator = numberGenerator
        )
    }
    val cars = Cars(cars = carList)

    printView.print(message = RacingConstants.USER_INPUT_COUNT_HELP)
    val rap = inputView.input()
    validator.validateDigit(digitString = rap)

    val track = Track(rap = rap.toInt())
    val ranking = Ranking()
    track.setup(cars = cars, ranking = ranking)
    val racingResult = track.start()

    racingResult.map { round ->
        round.value.map { result ->
            printView.print(result)
        }
        printView.print(RacingConstants.PRINT_DIVIDER)
    }
}
