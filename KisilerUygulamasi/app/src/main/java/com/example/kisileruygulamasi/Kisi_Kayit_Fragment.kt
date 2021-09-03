package com.example.kisileruygulamasi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_kisi__kayit_.view.*


class Kisi_Kayit_Fragment : Fragment() {
    private lateinit var tasarim:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim =  inflater.inflate(R.layout.fragment_kisi__kayit_, container, false)

        tasarim.button_Kaydet.setOnClickListener {
            val kisiAdi = tasarim.EditTextKisiAd.text.toString()
            val kisiTelefon = tasarim.EditTextKisiTelefon.text.toString()
            kayit(kisiAdi,kisiTelefon)
        }
        return tasarim
    }

    fun kayit(kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Kayıt","$kisi_ad - $kisi_tel")
    }
}