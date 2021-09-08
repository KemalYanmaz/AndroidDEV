package com.example.kisileruygulamasi.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel

class KisiDetayFragmentViewModel : ViewModel() {
    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }
}