package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sayfa_a.view.*
import kotlinx.android.synthetic.main.fragment_sayfa_b.view.*

class SayfaBFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val tasarim =  inflater.inflate(R.layout.fragment_sayfa_b, container, false)
        tasarim.buttonBToY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_sayfaBFragment_to_sayfaYFragment)
        }
        return tasarim
    }
}