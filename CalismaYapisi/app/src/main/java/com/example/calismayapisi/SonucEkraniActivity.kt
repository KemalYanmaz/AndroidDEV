package com.example.calismayapisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_sonuc_ekrani.*

class SonucEkraniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_ekrani)
    }

    var sayi = 0


    override fun onBackPressed() {
        if(sayi==1){
            super.onBackPressed()
        }else{
            //Toast.makeText(applicationContext,"Tıklandı",Toast.LENGTH_LONG).show()
            Snackbar.make(textView3,"Tıklandı",Snackbar.LENGTH_SHORT).show()
        }
        sayi++
    }


}