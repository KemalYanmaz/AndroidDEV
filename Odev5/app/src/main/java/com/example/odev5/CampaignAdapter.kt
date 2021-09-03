package com.example.odev5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CampaignAdapter(var mContext: Context,var campaignList:List<Campaign>) : RecyclerView.Adapter<CampaignAdapter.CampaignTasarimTutucu>(){
    inner class CampaignTasarimTutucu(view: View) : RecyclerView.ViewHolder(view){
        var image:ImageView
        var description:TextView
        var button: Button

        init {
            image = view.findViewById(R.id.campaign_image)
            description = view.findViewById(R.id.tv_campaign)
            button = view.findViewById(R.id.button_campaign)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_campaign,parent,false)
        return CampaignTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CampaignTasarimTutucu, position: Int) {
        val campaign = campaignList.get(position)
        val resourceId = mContext.getResources().getIdentifier(campaign.image, "drawable",mContext.getPackageName());
        holder.image.setImageResource(resourceId);
        holder.description.text = campaign.description
    }

    override fun getItemCount(): Int {
        return campaignList.size
    }
}