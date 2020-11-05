package com.github.overcastan.hw2problems

fun sum(a: IntArray): Int {
    var Sigma = 0
    for (elem in a) Sigma += elem
    return Sigma
}