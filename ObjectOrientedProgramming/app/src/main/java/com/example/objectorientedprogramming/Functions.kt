package com.example.objectorientedprogramming

fun main() {
    sayHi()
    sayHi("Kemal")
}

fun sayHi(name:String):String{
    return "Hi $name"
}

fun sayHi():String{
    return "Hi Ahmet"
}