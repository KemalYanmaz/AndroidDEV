package com.example.objectorientedprogramming.car

fun main() {
    val bmw = Car("BMW","red")
    bmw.getInfo()
    bmw.run()
    bmw.speedUp(10)
    bmw.getInfo()
    bmw.speedDown(10)
    bmw.getInfo()

}