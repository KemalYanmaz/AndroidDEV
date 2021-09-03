package com.example.odev5

import java.io.Serializable

data class ProductWithDiscount(var name:String,var image:String,var price:Double,var discountedPrice:Double):Serializable{


}