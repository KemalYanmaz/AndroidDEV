package com.example.calismayapisi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorRes
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_oyun_ekrani.*
import kotlinx.android.synthetic.main.activity_oyun_ekrani.view.*

class OyunEkraniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun_ekrani)

        val gelenVeri = intent.getStringExtra("veri")
        if(gelenVeri!!.contains("kotlin")){
            text_ad.setTextColor(Color.GREEN)
        }else{
            text_ad.setTextColor(Color.RED)
        }
        text_ad.text = gelenVeri

        buttonBitir.setOnClickListener {
            val intent = Intent(this@OyunEkraniActivity,SonucEkraniActivity::class.java)
            finish()
            startActivity(intent)
        }

    }

}