package com.example.recyclerviewkullanimi
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_anasayfa.*
import kotlinx.android.synthetic.main.fragment_anasayfa.view.*

class Anasayfa_Fragment : Fragment() {
    private lateinit var tasarim:View
    private lateinit var filmlerListesi:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = inflater.inflate(R.layout.fragment_anasayfa, container, false)

        tasarim.rv_film.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        filmlerListesi = ArrayList()

        val f1 = Filmler(1,"Anadoluda","anadoluda",5.87,7.5,false)
        val f2 = Filmler(2,"Django","django",12.9,8.1,true)
        val f3 = Filmler(1,"Inception","inception",15.6,8.8,true)
        val f4 = Filmler(1,"Interstellar","interstellar",20.2,8.6,false)
        val f5= Filmler(1,"The Hateful Eight","thehatefuleight",9.6,7.9,true)
        val f6 = Filmler(1,"The Pianist","thepianist",11.7,8.5,false)

        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        adapter= FilmlerAdapter(requireContext(),filmlerListesi)
        tasarim.rv_film.adapter = adapter

        return tasarim
    }
}