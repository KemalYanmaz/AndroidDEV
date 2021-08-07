package com.example.objectorientedprogramming.collections

import kotlin.collections.HashSet

fun main() {
    val numbers = HashSet<Int>()

    val fruits = HashSet<String>()

    fruits.add("Banana")
    fruits.add("Kivi")
    fruits.add("Apple")

    println(fruits.joinToString())

    val fruit = fruits.elementAt(2)
    println("2nd index of fruits : ${fruit}")
}