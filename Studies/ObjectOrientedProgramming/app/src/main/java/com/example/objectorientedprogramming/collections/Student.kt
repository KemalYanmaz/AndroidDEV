package com.example.objectorientedprogramming.collections

class Student(var number:Int,var name:String,var classroom:String) {

    override fun toString():String{
        return "$number" + name+" "+ classroom
    }
}