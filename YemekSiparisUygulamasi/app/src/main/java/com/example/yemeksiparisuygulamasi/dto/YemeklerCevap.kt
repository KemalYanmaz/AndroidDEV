package com.example.yemeksiparisuygulamasi.dto

import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YemeklerCevap(@SerializedName("yemekler")
                         @Expose
                         var yemekler:List<Yemek>,
                         @SerializedName("success")
                         @Expose
                         var success:Int){
}