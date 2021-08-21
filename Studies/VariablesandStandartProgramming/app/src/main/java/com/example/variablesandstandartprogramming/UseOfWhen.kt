package com.example.variablesandstandartprogramming

fun main() {
    val choose = 6

    when(choose){
        1->{
            println("First Item Selected")
            println("OK")
        }
        2->println("Second Item Selected")
        3->println("Third Item Selected")
        else-> println("There exist no such item: $choose")
    }
}