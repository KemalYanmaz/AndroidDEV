package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.entity.Kisiler

class AnasayfaFragmentViewModel : ViewModel() {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }

    fun kisileriYukle(){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","888888888")
        val k2 = Kisiler(2,"Zeynep","777777777")
        val k3 = Kisiler(3,"Mehmet","333333333")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)
        kisilerListesi.value = liste
    }

    fun sil(kisi_id:Int){
        Log.e("Kişi Sil","$kisi_id")
    }

}