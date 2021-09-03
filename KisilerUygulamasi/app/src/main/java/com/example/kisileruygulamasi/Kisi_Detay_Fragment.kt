package com.example.kisileruygulamasi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_kisi__detay_.view.*

class Kisi_Detay_Fragment : Fragment() {
    private lateinit var tasarim : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = inflater.inflate(R.layout.fragment_kisi__detay_, container, false)
        tasarim.button_Guncelle.setOnClickListener {
            val kisi_ad = tasarim.EditTextKisiAd.text.toString()
            val kisi_tel = tasarim.EditTextKisiTel.text.toString()
            guncelle(1,kisi_ad,kisi_tel)
        }
        return tasarim
    }

    fun guncelle(kisi_ID:Int,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_ID - $kisi_ad - $kisi_tel")
    }
}