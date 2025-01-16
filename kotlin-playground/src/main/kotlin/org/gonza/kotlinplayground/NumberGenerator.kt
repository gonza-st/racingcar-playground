package org.gonza.kotlinplayground

interface NumberGenerator {
    val range: Int

    fun generate(): Int
}
