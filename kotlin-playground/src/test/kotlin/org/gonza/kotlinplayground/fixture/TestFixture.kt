package org.gonza.kotlinplayground.fixture

import org.gonza.kotlinplayground.domain.NumberGenerator

class TestFixture {
    companion object {
        fun getMovedNumberGenerator(): NumberGenerator = MovedNumberGenerator()

        fun getStayNumberGenerator(): NumberGenerator = StayNumberGenerator()
    }
}
