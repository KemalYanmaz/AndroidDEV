package com.example.yemeksiparisuygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.MainActivity
import com.example.yemeksiparisuygulamasi.adapter.YemekAdapter
import com.example.yemeksiparisuygulamasi.dto.YemeklerCevap
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.repository.YemekDaoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnasayfaViewModel: ViewModel() {

    var yemekListesi =MutableLiveData<List<SepettekiYemek>>()
    var mrepo= YemekDaoRepository()
    var sepettekiYemekler=MutableLiveData<Map<Int,SepettekiYemek>>()

    init {
        mrepo = YemekDaoRepository()
        yemekListesi = mrepo.yemeklerListesiniGetir()
        sepettekiYemekler = mrepo.getSepettekiUrunler()
    }

}