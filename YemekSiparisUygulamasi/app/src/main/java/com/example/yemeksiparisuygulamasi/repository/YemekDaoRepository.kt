package com.example.yemeksiparisuygulamasi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemeksiparisuygulamasi.MainActivity
import com.example.yemeksiparisuygulamasi.dto.CRUDCevap
import com.example.yemeksiparisuygulamasi.dto.SepettekiYemeklerCevap
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.dto.YemeklerCevap
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.retrofit.ApiUtils
import com.example.yemeksiparisuygulamasi.retrofit.YemekDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class YemekDaoRepository {
    private val yemekDaoInterface:YemekDaoInterface
    private val yemeklerListesi:MutableLiveData<List<SepettekiYemek>>
    private val sepettekiYemekler:MutableLiveData<Map<Int,SepettekiYemek>>
    private val sepetTutari:MutableLiveData<Float>
    private val sepettekiYemek:MutableLiveData<SepettekiYemek>

    init {
        yemekDaoInterface = ApiUtils.getYemekDaoInterface()
        yemeklerListesi = MutableLiveData()
        sepettekiYemekler = MutableLiveData()
        sepettekiYemek = MutableLiveData()
        sepetTutari = MutableLiveData(0f)
        yemeklerListesiniGuncelle()
        sepettekiUrunleriGuncelle(MainActivity.kullanici)
    }

    //Anasayfa
    fun yemeklerListesiniGuncelle(){
        yemekDaoInterface.tumYemekleriGetir().enqueue(object:Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                val liste2 = ArrayList<SepettekiYemek>()
                for(yemek in liste){
                    liste2.add(SepettekiYemek(yemek.id,yemek.ad,yemek.resimAd,yemek.fiyat,0,MainActivity.kullanici))
                }
                yemeklerListesi.value = liste2
            }
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }
    fun yemeklerListesiniGetir():MutableLiveData<List<SepettekiYemek>>{
        return yemeklerListesi
    }

    //Detay Sayfası
    fun urunuEkle(yemek: SepettekiYemek) {
        yemekDaoInterface.sepettenYemekCikar(yemek.id)

        if(yemek.adet>0){
            yemekDaoInterface.sepeteYemekEkle(yemek.id,yemek.ad,yemek.resimAd,yemek.fiyat,yemek.adet,MainActivity.kullanici)
        }

        sepettekiUrunleriGuncelle(MainActivity.kullanici)
    }
    fun getSepettekiYemek():MutableLiveData<SepettekiYemek>{
        return sepettekiYemek
    }

    //Sepet
    fun sepettekiUrunleriGuncelle(kullaniciAdi: String){
        yemekDaoInterface.sepettekiYemekleriGetir(kullaniciAdi).enqueue(object:Callback<SepettekiYemeklerCevap>{
            override fun onResponse(call: Call<SepettekiYemeklerCevap>, response: Response<SepettekiYemeklerCevap>) {
                val sepetListesi = response.body().sepettekiYemekler
                val map = HashMap<Int,SepettekiYemek>()
                var toplamFiyat=0f
                for(sepettekiyemek in sepetListesi){
                    map.put(sepettekiyemek.id,sepettekiyemek)
                    toplamFiyat+=sepettekiyemek.fiyat*sepettekiyemek.adet

                }
                val liste2 = ArrayList<SepettekiYemek>()
                yemeklerListesi.value?.forEach {
                  if(map.get(it.id)!=null){
                      liste2.add(map.get(it.id)!!)
                  }else{
                      liste2.add(it)
                  }
                }
                yemeklerListesi.postValue(liste2)
                sepettekiYemekler.postValue(map)
                sepetTutari.postValue(toplamFiyat)


            }
            override fun onFailure(call: Call<SepettekiYemeklerCevap>?, t: Throwable?) {}
        })
    }
    fun getSepetTutari():MutableLiveData<Float>{
        return sepetTutari
    }
    fun getSepettekiUrunler():MutableLiveData<Map<Int,SepettekiYemek>>{
        return sepettekiYemekler
    }
    fun urunAdetDusur(yemek: SepettekiYemek) {
        yemek.adet--
        urunuEkle(yemek)
    }
    fun urunAdetArttir(yemek: SepettekiYemek) {
        yemek.adet++
        urunuEkle(yemek)
    }


}