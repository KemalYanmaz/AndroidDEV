package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class KisiKayitFragmentViewModel : ViewModel() {
    fun kayit(kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Kayıt","$kisi_ad-$kisi_tel")
    }
}