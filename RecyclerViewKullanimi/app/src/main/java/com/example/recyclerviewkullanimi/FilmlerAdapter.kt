package com.example.recyclerviewkullanimi
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

//1.Adım sınıf parametreleri
class FilmlerAdapter(var mContext: Context, var filmlerListesi:List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.cardTasarimTutucu>(){

    //2.Adım innerclass
    inner class cardTasarimTutucu(view: View): RecyclerView.ViewHolder(view)
    {
        //3.Adım innerclass'ı adaptera bağlama
        var film_card:CardView
        var imageView_resim:ImageView
        var imageView_favori:ImageView
        var imageView_dahafazla:ImageView
        var tv_ad:TextView
        var tv_fiyat:TextView
        var tv_puan:TextView
        var buttonSatinAl:Button

        init {
            film_card = view.findViewById(R.id.film_card)
            imageView_resim = view.findViewById(R.id.imageView_resim)
            imageView_favori = view.findViewById(R.id.imageView_favori)
            imageView_dahafazla = view.findViewById(R.id.imageViewDahaFazla)
            tv_ad = view.findViewById(R.id.tv_ad)
            tv_fiyat = view.findViewById(R.id.tv_fiyat)
            tv_puan = view.findViewById(R.id.tv_puan)
            buttonSatinAl = view.findViewById(R.id.buttonSatinAl)
        }
    }

    //4.Adım Veri kümesi boyutunu belirleme
    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

    //5.Adım card tasarımını sınıfa bağlama
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return cardTasarimTutucu(tasarim)
    }

    //6.Adım card tasarımı üzerinde görsel nesne yerleştirmeleri
    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        holder.tv_ad.text = film.ad
        holder.tv_fiyat.text = "₺${film.fiyat}"
        holder.tv_puan.text = "${film.puan} / 10"
        holder.imageView_resim.setImageResource(mContext.resources.getIdentifier(film.resim_ad,"drawable",mContext.packageName))
        holder.buttonSatinAl.setOnClickListener {
            Snackbar.make(it,"${film.ad} filmi ₺${film.fiyat} fiyatına satın alındı!",Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.rgb(221,41,21))
                .setTextColor(Color.WHITE).show()
        }
        if(film.isFavorite){
            holder.imageView_favori.setImageResource(R.drawable.favori_resim_true)
        }else{
            holder.imageView_favori.setImageResource(R.drawable.favori_resim_false)
        }

        holder.imageView_dahafazla.setOnClickListener{
            val popup = PopupMenu(mContext,it)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_indirim->{
                        Toast.makeText(mContext,"${film.ad} indirim haberi için kaydedildi.",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_favori->{
                        Toast.makeText(mContext,"${film.ad} favorilere eklendi.",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }

}