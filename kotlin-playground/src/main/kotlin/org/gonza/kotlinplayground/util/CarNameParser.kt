package org.gonza.kotlinplayground.util

import org.gonza.kotlinplayground.service.vo.CarName

class CarNameParser {
    companion object {
        private const val SPLIT_KEYWORD = ","

        fun parse(carName: CarName): List<CarName> =
            carName.value
                .split(SPLIT_KEYWORD)
                .map { it.trim() }
                .map { CarName(it) }

        fun toCarNameString(carNameList: List<CarName>): String = carNameList.joinToString(SPLIT_KEYWORD) { it.value }
    }
}
