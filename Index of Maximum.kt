package com.github.overcastan.hw2problems
import java.lang.Integer.MIN_VALUE

fun indexOfMax(a: IntArray): Int? {
    if (a.isEmpty()) return null
    var maxElemIndex = 0
    var tempMax: Int = MIN_VALUE
    for (i in a.indices) {
        if(a[i] >= tempMax){
            tempMax = a[i]
            maxElemIndex = i
        }
    }
    return maxElemIndex
}