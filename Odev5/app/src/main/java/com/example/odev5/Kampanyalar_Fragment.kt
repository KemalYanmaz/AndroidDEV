package com.example.odev5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_kampanyalar_.view.*
import kotlinx.android.synthetic.main.fragment_siparis.view.*

class Kampanyalar_Fragment : Fragment() {
    private lateinit var tasarim:View
    private lateinit var campaignList:ArrayList<Campaign>
    private lateinit var campaignAdapter: CampaignAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = inflater.inflate(R.layout.fragment_kampanyalar_, container, false)

        tasarim.rv_kampanyalar.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        campaignList = ArrayList()

        campaignList.add(Campaign("Eti Alasko Frigo çeşitlerinde %50 indirim!","kampanya"))
        campaignList.add(Campaign("Seçili ürünler sepette 2 TL!","kampanya2"))
        campaignList.add(Campaign("25 TL ve üzeri Sensodyne ve Paradontax siparişine gönderim ücreti yok!","kampanya3"))

        campaignAdapter = CampaignAdapter(requireContext(),campaignList)

        tasarim.rv_kampanyalar.adapter = campaignAdapter
        return tasarim
    }
}