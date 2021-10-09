package com.example.yemeksiparisuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.MainActivity
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.repository.YemekDaoRepository

class SepetViewModel : ViewModel(){

    var sepettekiUrunlerListesi=MutableLiveData<Map<Int,SepettekiYemek>>()
    var mRepo = YemekDaoRepository()

    init {
        sepettekiUrunlerListesi = mRepo.getSepettekiUrunler()
        yemekleriGetir()
    }

    fun yemekleriGetir(){
        mRepo.sepettekiUrunleriGuncelle(MainActivity.kullanici)
    }
    fun adetDusur(yemek:SepettekiYemek){
        mRepo.urunAdetDusur(yemek)
    }

    fun adetArttir(yemek:SepettekiYemek){
        mRepo.urunAdetArttir(yemek)
    }

}