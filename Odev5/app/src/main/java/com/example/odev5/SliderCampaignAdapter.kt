package com.example.odev5

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class SliderCampaignAdapter (var mContext: Context, var slideList:List<SliderCampaign>) :RecyclerView.Adapter<SliderCampaignAdapter.SliderTasarimTutucu>() {

    inner class SliderTasarimTutucu(view: View) : RecyclerView.ViewHolder(view){
        var imageView : RoundedImageView
        init {
            imageView = view.findViewById(R.id.imageSlide)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.slide_item_container,parent,false)
        return SliderTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SliderTasarimTutucu, position: Int) {
        val slider = slideList.get(position)
        val resourceId = mContext.getResources().getIdentifier(slider.image, "drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resourceId);
    }

    override fun getItemCount(): Int {
        return slideList.size
    }
}