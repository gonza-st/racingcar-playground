package org.gonza.kotlinplayground.utils

class Validator {
    fun stringLengthValidate(target: String, length: Int) {
        if (target.length > length) {
            throw IllegalArgumentException("문자열의 길이가 입력한 길이를 초과합니다.")
        }

        return
    }

}