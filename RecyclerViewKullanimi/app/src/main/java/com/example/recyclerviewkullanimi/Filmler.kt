package com.example.recyclerviewkullanimi

import java.io.Serializable

data class Filmler(var ID:Int,
                   var ad:String,
                   var resim_ad:String,
                   var fiyat:Double,
                   var puan:Double,
                   var isFavorite:Boolean) : Serializable{



}