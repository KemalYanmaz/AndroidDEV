package com.example.odev5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_sepetim_.view.*
import kotlinx.android.synthetic.main.fragment_siparis.view.*


class Sepetim_Fragment : Fragment() {
    private lateinit var tasarim:View
    private lateinit var categoryList:ArrayList<Category>
    private lateinit var categoryAdapter:CategoryAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim =inflater.inflate(R.layout.fragment_sepetim_, container, false)


        tasarim.rv_sepetim_kategoriler.layoutManager = StaggeredGridLayoutManager(4,
            StaggeredGridLayoutManager.VERTICAL)

        categoryList = ArrayList()

        categoryList.add(Category("Su","water"))
        categoryList.add(Category("Meyve","lemon"))
        categoryList.add(Category("Kahvaltılık","kahvaltilik"))
        categoryList.add(Category("Atıştırma","cikolata"))
        categoryList.add(Category("İçecek","cola"))
        categoryList.add(Category("Yiyecek","cornet"))
        categoryList.add(Category("Evcil Hayvan","evcilhayvan"))
        categoryList.add(Category("Temel Gıda","ekmek"))
        categoryList.add(Category("Ev Bakım","deterjan"))
        categoryList.add(Category("Donuk","donuk"))
        categoryList.add(Category("Teknoloji","bilgisayar"))
        categoryList.add(Category("Giyim","giyim"))
        categoryList.add(Category("Kişisel Bakım","bakim"))

        categoryAdapter = CategoryAdapter(requireContext(),categoryList)
        tasarim.rv_sepetim_kategoriler.adapter = categoryAdapter

        return tasarim
    }
}