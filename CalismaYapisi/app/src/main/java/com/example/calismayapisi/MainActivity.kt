package com.example.calismayapisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOyna.setOnClickListener {
            val intent = Intent(this@MainActivity,OyunEkraniActivity::class.java)
            val girdi = editTextGirdi.text.toString()

            intent.putExtra("veri",girdi)
            startActivity(intent)
        }

    }
}