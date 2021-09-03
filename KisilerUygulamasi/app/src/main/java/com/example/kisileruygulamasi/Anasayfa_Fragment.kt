package com.example.kisileruygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_anasayfa_.view.*

class Anasayfa_Fragment : Fragment() {
    private lateinit var tasarim : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim =  inflater.inflate(R.layout.fragment_anasayfa_, container, false)

        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisi_detay_gecis)
        }

        return tasarim
    }

}