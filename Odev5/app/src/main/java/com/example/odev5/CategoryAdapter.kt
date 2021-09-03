package com.example.odev5

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(var mContext: Context, var categoryList:List<Category>) : RecyclerView.Adapter<CategoryAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(view: View):RecyclerView.ViewHolder(view){
        var categoryImage:ImageView
        var categoryName:TextView

        init{
            categoryImage = view.findViewById(R.id.category_image)
            categoryName = view.findViewById(R.id.category_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_category,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val category = categoryList.get(position)
        val resourceId = mContext.getResources().getIdentifier(category.image, "drawable",mContext.getPackageName());
        holder.categoryImage.setImageResource(resourceId);
        holder.categoryName.text = category.name
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}