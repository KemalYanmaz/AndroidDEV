package com.example.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_oyun_ekrani.view.*

class OyunEkrani : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val tasarim = inflater.inflate(R.layout.fragment_oyun_ekrani,container,false)
        val bundle:OyunEkraniArgs by navArgs()
        val gelenMesaj = bundle.mesaj
        val gelenIsim = bundle.isim
        val gelenYas = bundle.yas
        val gelenBoy = bundle.boy
        val gelenBekarMi = bundle.bekarMi
        val gelenNesne = bundle.nesne
        val gelenAd = gelenNesne.ad
        val gelenYas2 = gelenNesne.yas.toString()
        val gelenTC = gelenNesne.tcno.toString()
        Log.e("Gelen",gelenMesaj+gelenIsim+gelenYas+gelenBoy+gelenBekarMi)
        Log.e("Gelen nesne",gelenNesne.toString())
        tasarim.buttonBitir.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.sonucEkraniGecis)
        }
        return tasarim
    }


}