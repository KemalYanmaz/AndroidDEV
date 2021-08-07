package com.example.objectorientedprogramming.collections

fun main() {
    val cities = HashMap<Int,String>()

    cities.put(1,"Adana")
    cities.put(2,"Adıyaman")
    cities.put(34,"İstanbul")
    cities.put(67,"Zonguldak")

    println(cities.toString())

    println(cities.get(34))

    println("Size: ${cities.size}")

    for((key,value) in cities){
        println("$key - $value")
    }
}