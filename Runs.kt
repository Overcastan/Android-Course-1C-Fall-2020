package com.github.overcastan.hw2problems

fun runs(a: IntArray): Int {
    if(a.isEmpty()) return 0
    var runsNum = 1
    for (i in 1..a.size - 1){
        if (a[i] != a[i-1]) ++runsNum
    }
    return runsNum
}