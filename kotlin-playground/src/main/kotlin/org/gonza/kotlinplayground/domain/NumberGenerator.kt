package org.gonza.kotlinplayground.domain

interface NumberGenerator {
    val range: Int

    fun generate(): Int
}
