package com.example.odev5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Anasayfa_Fragment : Fragment() {
    private lateinit var tasarim:View;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = inflater.inflate(R.layout.fragment_anasayfa_, container, false)


        return tasarim
    }

}