package com.example.yemeksiparisuygulamasi.retrofit

import com.example.yemeksiparisuygulamasi.dto.CRUDCevap
import com.example.yemeksiparisuygulamasi.dto.SepettekiYemeklerCevap
import com.example.yemeksiparisuygulamasi.dto.YemeklerCevap
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.entity.Yemek
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemekDaoInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekleriGetir():Call<YemeklerCevap>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepettekiYemekleriGetir(@Field("kullanici_adi")kullaniciAdi:String):Call<SepettekiYemeklerCevap>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepeteYemekEkle(@Field("yemek_id")yemekId:Int,
                        @Field("yemek_adi")yemekAdi:String,
                        @Field("yemek_resim_adi")yemekResimAdi:String,
                        @Field("yemek_fiyat")yemekFiyat:Float,
                        @Field("yemek_siparis_adet")adet:Int,
                        @Field("kullanici_adi")kullaniciAdi: String):Call<CRUDCevap>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepettenYemekCikar(@Field("yemek_id")yemekId:Int):Call<CRUDCevap>

}


