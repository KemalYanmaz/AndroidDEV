package com.example.objectorientedprogramming.car

class Car(var isim:String,var color:String) {


    init {
        println("Sınıftan nesne oluşturuldu.")
    }
    var isWorking = false
    var speed = 0
    fun run(){
        isWorking = true
        println("$isim calistirildi.")
    }

    fun stop(){
        isWorking = false
        println("$isim durduruldu.")
    }

    fun speedUp(hiz:Int){
        speed+=hiz
        println("$isim hızlandı. Hızı: $speed")
    }

    fun speedDown(hiz:Int){
        speed-=hiz
        println("$isim yavaşladı. Hızı: $speed")
        if(speed<=0){
            stop()
        }
    }

    fun getInfo(){
        if (isWorking){
            println("$isim; ${color} renkte, hızı ${speed} ve şuanda çalışıyor.")
        }else{
            println("$isim; ${color} renkte, hızı ${speed} ve şuanda çalışmıyor.")
        }
    }
}