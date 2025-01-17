package org.gonza.kotlinplayground

class Accelerate(val numberGenerator: NumberGenerator) {
    fun press(): Motion {
        val number = numberGenerator.generate()
        if(number < 5){
            return Motion.BREAK
        }
        return Motion.MOVE
    }
}
