package org.gonza.kotlinplayground.utils

interface Generator<T> {
    fun generate(): T
}

interface TargetGenerator<T, K> {
    fun generate(target: T): K
}