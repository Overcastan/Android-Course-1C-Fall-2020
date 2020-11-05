package com.github.overcastan.hw2problems

fun isPalindrome(s: String): Boolean {
//     if(s.length < 2) return true
//     for(i in 0..s.length -1){
//         if(s[i] != s[s.length - 1 - i]) return false
//     }
//     return true
    return s == s.reversed()
}