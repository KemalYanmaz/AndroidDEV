package com.example.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.imageview_calismasi.*

class ImageviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imageview_calismasi)

        buttonResim1.setOnClickListener {
            imageView.setImageResource(R.drawable.resim1)
        }

        buttonResim2.setOnClickListener {
            imageView.setImageResource(resources.getIdentifier("resim2","drawable",packageName))
        }

        buttonResim3.setOnClickListener{
            val url = "http://kasimadalan.pe.hu/filmler/resimler/interstellar.png"
            Picasso.get().load(url).into(imageView)

        }
    }
}