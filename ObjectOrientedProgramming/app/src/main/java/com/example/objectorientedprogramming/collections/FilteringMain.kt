package com.example.objectorientedprogramming.collections

fun main() {
    val students = ArrayList<Student>()

    val student1 = Student(100,"Ahmet","11F")
    val student2 = Student(130,"Mehmet","12C")
    val student3 = Student(80,"Zeynep","10H")

    students.add(student1)
    students.add(student2)
    students.add(student3)

    for(student in students){
        println(student)
    }

    var filtering = students.filter { it.number>=100 }

    filtering = students.filter{it.name.contains("a")}


}