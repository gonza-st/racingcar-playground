package org.gonza.kotlinplayground.rule

class FakeNumberGeneratorImpl(private val number: Int): NumberGenerator {
    init {
        require(number in 0..9) { "숫자는 0에서 9 사이여야 합니다" }
    }
    override fun generate(): Int {
        return number
    }
}