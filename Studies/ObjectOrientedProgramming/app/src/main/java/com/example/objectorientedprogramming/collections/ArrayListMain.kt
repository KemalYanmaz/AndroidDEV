package com.example.objectorientedprogramming.collections

fun main(){
    val fruits = ArrayList<String>()

    fruits.add("Banana")
    fruits.add("Apple")
    fruits.add("Melon")
    fruits.add("Orange")

    println(fruits.joinToString())

    fruits[2] = "Watermelon"

    println(fruits.joinToString())

    fruits.add(1,"Lemon")

    println(fruits.joinToString())

    val fruit1 = fruits.get(3)
    println("3rd index is $fruit1")

    val fruit2 = fruits[4]
    println("4th index is $fruit2")

    println("The size of Arraylist is : ${fruits.count()}")
    println("The size of Arraylist is : ${fruits.size}")
    println("Is the Arraylist empty : ${fruits.isEmpty()}")
    println("The first element of Arraylist is : ${fruits.first()}")
    println("The last element of Arraylist is : ${fruits.last()}")

    fruits.reverse()
    println("The reverse of Arraylist is : ${fruits.joinToString()}")

    fruits.sort()
    println("The sorted case of Arraylist is : ${fruits.joinToString()}")

    for((index,fruit) in fruits.withIndex()){
        println("$index-$fruit")
    }

    fruits.removeAt(2)
    println("Fruits without index 2 is : ${fruits.joinToString()}")
}