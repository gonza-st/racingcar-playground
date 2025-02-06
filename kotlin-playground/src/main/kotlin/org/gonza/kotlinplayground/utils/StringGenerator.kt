package org.gonza.kotlinplayground.utils

import org.gonza.kotlinplayground.config.RacingConstants

class StringGenerator : TargetGenerator<String, List<String>> {
    override fun generate(target: String): List<String> {
        val list = target.split(RacingConstants.INPUT_DELIMITER)
        return list
    }

}