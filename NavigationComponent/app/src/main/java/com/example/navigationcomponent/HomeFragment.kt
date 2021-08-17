package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val tasarim = inflater.inflate(R.layout.fragment_home,container,false)
        val kisi = Kisi("Kemal",23,11111)
        val gecis = HomeFragmentDirections.oyunEkraniGecis("Merhaba",23,1.78f,true,"Kemal",kisi)

        tasarim.buttonBasla.setOnClickListener{
            Navigation.findNavController(it).navigate(gecis)
        }

        return tasarim
    }


}