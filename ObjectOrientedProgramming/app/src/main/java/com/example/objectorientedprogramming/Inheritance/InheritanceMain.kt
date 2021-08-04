package com.example.objectorientedprogramming.Inheritance

fun main() {
    val houses=ArrayList<House>()
    val house1 = House(4)
    val palace1 = Palace(2,4)
    val villa1 = Villa(true,4)
    houses.add(house1)
    houses.add(palace1)
    houses.add(villa1)

    for( house in houses){
        getInfo(house)
    }
}

fun getInfo(house:House){
    if(house is Palace){
        println("The Palace have ${house.numberOfWindow} windows and ${house.numberOfTower} towers ")

    }else if(house is Villa){
        if(house.haveGarage){
            println("The Villa has ${house.numberOfWindow} windows and garage")
        }else{
            println("The House has ${house.numberOfWindow} windows but have no garage")
        }
    }
    else{
        println("The House has ${house.numberOfWindow} windows")
    }
}