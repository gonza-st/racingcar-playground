package org.gonza.kotlinplayground

class TestFixture {
    companion object {
        fun getMovedNumberGenerator(): NumberGenerator = MovedNumberGenerator()

        fun getStayNumberGenerator(): NumberGenerator = StayNumberGenerator()
    }
}
