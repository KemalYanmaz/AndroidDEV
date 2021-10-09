package com.example.yemeksiparisuygulamasi.dto

import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.google.gson.annotations.SerializedName

data class SepettekiYemeklerCevap(@SerializedName("sepet_yemekler") var sepettekiYemekler:List<SepettekiYemek>,
                                  @SerializedName("success")var success:Int) {

}