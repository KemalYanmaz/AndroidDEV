package com.example.objectorientedprogramming.collections

fun main() {
    val students = ArrayList<Student>()

    val student1 = Student(100,"Ahmet","11F")
    val student2 = Student(130,"Mehmet","12C")
    val student3 = Student(80,"Zeynep","10H")

    students.add(student1)
    students.add(student2)
    students.add(student3)

    for((index,student) in students.withIndex()){
        println("***Student ${index+1}***")
        println("Name: ${student.name}")
        println("Number: ${student.number}")
        println("Class: ${student.classroom}")
    }

    var sorting = students.sortedWith(compareBy({it.number}))


    for((index,student) in sorting.withIndex()){
        println("***Student ${index+1}***")
        println("Name: ${student.name}")
        println("Number: ${student.number}")
        println("Class: ${student.classroom}")
    }

    sorting = students.sortedWith(compareByDescending({it.name}))
    for((index,student) in sorting.withIndex()){
        println("***Student ${index+1}***")
        println("Name: ${student.name}")
        println("Number: ${student.number}")
        println("Class: ${student.classroom}")
    }

    sorting = students.sortedWith(compareByDescending({it.number}))

}