package com.example.variablesandstandartprogramming

fun main() {
    var number = 42.56

    var result = number.toInt()
    println(result)

    var text = number.toString()
    println(text)

    var text2 = "48"

    var number2 = text2.toIntOrNull()
    
    if(number2!=null){
        println("Sayı: $number2")
    }else{
        println("Hata Oluştu.")
    }
}