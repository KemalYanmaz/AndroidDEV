package com.example.objectorientedprogramming.Character

fun main() {
    val char1= Character("Kemal",100,20)
    val char2 = Character("Ulaş",120,30)
    char1.attack(char2)
    char2.combo(char1)
}