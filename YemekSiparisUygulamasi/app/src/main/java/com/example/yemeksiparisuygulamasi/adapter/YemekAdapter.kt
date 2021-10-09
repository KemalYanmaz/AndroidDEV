package com.example.yemeksiparisuygulamasi.adapter

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.MainActivity
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimBinding
import com.example.yemeksiparisuygulamasi.entity.SepettekiYemek
import com.example.yemeksiparisuygulamasi.entity.Yemek
import com.example.yemeksiparisuygulamasi.fragment.AnasayfaFragment
import com.example.yemeksiparisuygulamasi.fragment.AnasayfaFragmentDirections
import com.example.yemeksiparisuygulamasi.retrofit.ApiUtils
import com.example.yemeksiparisuygulamasi.viewmodel.AnasayfaViewModel
import com.squareup.picasso.Picasso
import java.lang.NullPointerException

class YemekAdapter(var mContext: Context, var yemeklerListesi:List<SepettekiYemek>,var viewModel: AnasayfaViewModel): RecyclerView.Adapter<YemekAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding):RecyclerView.ViewHolder(cardTasarimBinding.root){
        var cardTasarimBinding: CardTasarimBinding

        init {
            this.cardTasarimBinding = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val card = holder.cardTasarimBinding

        var yemek = yemeklerListesi.get(position)

        try {
            if (viewModel.sepettekiYemekler.value!!.contains(yemek.id)) {
                yemek = viewModel.sepettekiYemekler.value!!.get(yemek.id)!!
            }
        }catch (e:NullPointerException){
            Log.e("HATA","${e.toString()} ${yemek.ad}")
        }

        Picasso.get().load(ApiUtils.BASE_URL+ApiUtils.RESIMLER_URL+yemek.resimAd).into(card.ivUrun)

        card.yemekNesnesi = yemek
        card.cardViewUrun.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToYemekDetayFragment(yemek,3.24f)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }

}