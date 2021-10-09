package com.example.yemeksiparisuygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.MainActivity
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.repository.YemekDaoRepository
import com.example.yemeksiparisuygulamasi.retrofit.ApiUtils
import kotlinx.coroutines.MainScope
import java.math.BigDecimal

class YemekDetayViewModel: ViewModel() {

    var mrepo:YemekDaoRepository
    var sepetTutari:MutableLiveData<Float>
    var yemek:MutableLiveData<SepettekiYemek>
    var yemekListesi:MutableLiveData<Map<Int,SepettekiYemek>>

    init {
        mrepo = YemekDaoRepository()
        sepetTutari = mrepo.getSepetTutari()
        yemek = mrepo.getSepettekiYemek()
        yemekListesi = mrepo.getSepettekiUrunler()
    }

    fun adetArttir(sayi:Int){
        val tempAdet = yemek.value!!.adet.toInt()
        yemek.value!!.adet = tempAdet + sayi
        yemek.postValue(yemek.value!!)
    }

    fun adetAzalt(sayi:Int){
        val tempAdet = yemek.value!!.adet
        if(tempAdet>=sayi) {
            yemek.value!!.adet = tempAdet - sayi
        }
        yemek.postValue(yemek.value!!)
    }

    fun urunuSepeteEkle(urun:SepettekiYemek){
        mrepo.urunuEkle(urun)
    }

}