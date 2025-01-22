package org.gonza.kotlinplayground.car

import org.gonza.kotlinplayground.rule.NumberGenerator

class Accelerate(val numberGenerator: NumberGenerator) {
    fun press(): Motion {
        val number = numberGenerator.generate()
        if(number < 5){
            return Motion.BREAK
        }
        return Motion.MOVE
    }
}
