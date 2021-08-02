package com.example.variablesandstandartprogramming

fun main() {
    for(i in 1..10){
        var text = ""
        for (j in 1..i){
            text += "*"
        }
        println(text)
    }

    for(i in 0..20 step 2){
        println(i)
    }

    for(i in 100 downTo 0 step 10){
        println("${i}%")
    }

    var counter = 1

    while(counter < 4){
        println("Counter: $counter")
        counter++
    }

    for(i in 1..5){
        if(i==4)
            break
        println("i is $i")
    }

    for(i in 1..5){
        if(i==3)
            continue
        println("i is $i")
    }
}