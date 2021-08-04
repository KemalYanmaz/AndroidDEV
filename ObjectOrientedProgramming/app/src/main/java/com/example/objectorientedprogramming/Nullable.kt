package com.example.objectorientedprogramming

fun main() {
    var str:String? = null

    println("Result 1 : ${str?.trim()}")
    println("Result 2 : ${str!!.trim()}")

    if(str!=null){
        println("Result 3 : ${str.trim()}")
    }
}