package com.example.navigationcomponent

import java.io.Serializable

data class Kisi(val ad:String,val yas:Int,val tcno:Int) :Serializable{

    override fun toString(): String {
        return "$ad $yas yaşında tc:$tcno"
    }
}