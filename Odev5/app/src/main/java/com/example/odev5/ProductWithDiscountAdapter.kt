package com.example.odev5

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class ProductWithDiscountAdapter(var mContext: Context, var productList:List<ProductWithDiscount>) :RecyclerView.Adapter<ProductWithDiscountAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(view: View) : RecyclerView.ViewHolder(view){
        var productImage:ImageView
        var productName:TextView
        var productPrice:TextView
        var productDiscountedPrice:TextView

        init{
            productImage = view.findViewById(R.id.im_product)
            productName = view.findViewById(R.id.tv_productName)
            productPrice = view.findViewById(R.id.tv_price)
            productDiscountedPrice = view.findViewById(R.id.tv_discounted_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_productwithdiscount,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val product = productList.get(position)
        val resourceId = mContext.getResources().getIdentifier(product.image, "drawable",mContext.getPackageName());
        holder.productImage.setImageResource(resourceId);
        holder.productName.text = product.name
        var dstr = SpannableString("${product.price} TL")
        dstr.setSpan(StrikethroughSpan(),0,dstr.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.productPrice.text = dstr
        holder.productDiscountedPrice.text = "${product.discountedPrice} TL"
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}