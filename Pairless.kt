package com.github.overcastan.hw2problems

fun findPairless(a: IntArray): Int {
    var lonely = a[0]
    for (i in 1..a.size - 1){
        lonely = lonely xor a[i]
    }
    return lonely
}