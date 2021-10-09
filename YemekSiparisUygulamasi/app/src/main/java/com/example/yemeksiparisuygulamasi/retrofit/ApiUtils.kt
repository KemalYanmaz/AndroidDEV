package com.example.yemeksiparisuygulamasi.retrofit

class ApiUtils {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"
        val RESIMLER_URL= "yemekler/resimler/"
        fun getYemekDaoInterface():YemekDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(YemekDaoInterface::class.java)
        }
    }
}


