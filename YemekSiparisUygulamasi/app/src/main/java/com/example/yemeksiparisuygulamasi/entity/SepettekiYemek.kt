package com.example.yemeksiparisuygulamasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SepettekiYemek (@SerializedName("yemek_id")
                           @Expose
                           var id:Int,
                           @SerializedName("yemek_adi")
                           @Expose
                           var ad:String,
                           @SerializedName("yemek_resim_adi")
                           @Expose
                           var resimAd:String,
                           @SerializedName("yemek_fiyat")
                           @Expose
                           var fiyat:Float,
                           @SerializedName("yemek_siparis_adet")
                           @Expose var adet:Int,
                           @SerializedName("kullanici_adi")
                           @Expose var kullanici:String):Serializable{

}


