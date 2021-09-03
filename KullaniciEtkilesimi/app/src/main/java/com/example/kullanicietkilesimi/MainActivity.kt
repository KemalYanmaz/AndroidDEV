package com.example.kullanicietkilesimi

import android.app.ProgressDialog.show
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_tasarim.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToast.setOnClickListener {
            Toast.makeText(this,"Toast'a tıklandı.",Toast.LENGTH_SHORT).show()

        }

        buttonSnackbar.setOnClickListener {
            Snackbar.make(it,"Silmek istiyor musunuz?",Snackbar.LENGTH_INDEFINITE)
                .setAction("Evet"){
                    Snackbar.make(it,"Silindi",Snackbar.LENGTH_SHORT)
                        .setActionTextColor(Color.BLUE)
                        .setBackgroundTint(Color.RED)
                        .show()
                }
                .setActionTextColor(Color.BLUE)
                .setBackgroundTint(Color.RED)
                .show()
        }

        buttonAlert.setOnClickListener {
            val alertTasarim = layoutInflater.inflate(R.layout.alert_tasarim,null)
            val editTextGirdi = alertTasarim.findViewById(R.id.editTextGirdi) as EditText

            val ad = AlertDialog.Builder(this@MainActivity)
            ad.setView(alertTasarim)
            ad.setTitle("Çıkış")
            ad.setPositiveButton("Evet"){d,i ->
                val gelenVeri = editTextGirdi.text.toString()
                Snackbar.make(it,"$gelenVeri",Snackbar.LENGTH_SHORT)
                    .setActionTextColor(Color.BLUE)
                    .setBackgroundTint(Color.RED)
                    .show()
            }
            ad.setNegativeButton("İptal"){d,i ->
                Snackbar.make(it,"Silme işlemi iptal edildi.",Snackbar.LENGTH_SHORT)
                    .setActionTextColor(Color.BLUE)
                    .setBackgroundTint(Color.RED)
                    .show()
            }

            ad.setIcon(R.drawable.ic_android_black_24dp)
            ad.create().show()
        }
    }
}