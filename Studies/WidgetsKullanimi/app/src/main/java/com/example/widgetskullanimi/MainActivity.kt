package com.example.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOku.setOnClickListener {
            val alinanVeri = editTextGirdi.text.toString().trim()
            if(alinanVeri.isEmpty()){
                Snackbar.make(it,"Eksik bilgi girmeyiniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(alinanVeri.length > 6){
                Snackbar.make(it,"6 karakterden fazla giremezsiniz.",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            textViewCikti.text = alinanVeri

        }

        fab.setOnClickListener {
            Snackbar.make(it,"Fab'a tıklandı",Snackbar.LENGTH_SHORT).show()
        }
    }
}