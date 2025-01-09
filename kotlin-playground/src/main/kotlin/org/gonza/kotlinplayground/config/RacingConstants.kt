package org.gonza.kotlinplayground.config

object RacingConstants {
    const val DEFAULT_CAR_NAME_LENGTH = 5
    const val RANDOM_NUMBER_MIN_VALUE = 0
    const val RANDOM_NUMBER_MAX_VALUE = 10
    const val RANDOM_NUMBER_THRESHOLD = 4

    const val USER_INPUT_CAR_NAME_HELP = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val USER_INPUT_COUNT_HELP = "시도할 회수는 몇회인가요?"
    const val INPUT_DELIMITER = ","
    const val INPUT_REGEX = "[!@#$%^&*()\\-_=+\\[\\]{}\\\\|;:'\",.<>/?]"
}
