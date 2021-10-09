package com.example.yemeksiparisuygulamasi.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimBinding
import com.example.yemeksiparisuygulamasi.databinding.SepetCardTasarimBinding
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.fragment.AnasayfaFragment
import com.example.yemeksiparisuygulamasi.fragment.AnasayfaFragmentDirections
import com.example.yemeksiparisuygulamasi.retrofit.ApiUtils
import com.example.yemeksiparisuygulamasi.viewmodel.AnasayfaViewModel
import com.example.yemeksiparisuygulamasi.viewmodel.SepetViewModel
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context, var yemeklerListesi:List<SepettekiYemek>,var viewModel: SepetViewModel): RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(cardTasarimBinding: SepetCardTasarimBinding):RecyclerView.ViewHolder(cardTasarimBinding.root){
        var cardTasarimBinding: SepetCardTasarimBinding

        init {
            this.cardTasarimBinding = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val card = holder.cardTasarimBinding

        Picasso.get().load(ApiUtils.BASE_URL+ApiUtils.RESIMLER_URL+yemek.resimAd).into(card.imageView)
        card.sepettekiYemek = yemek

        card.btnEksiBir2.setOnClickListener{
            viewModel.adetDusur(yemek)
        }

        card.btnArtiBir2.setOnClickListener{
            viewModel.adetArttir(yemek)
        }
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }



}