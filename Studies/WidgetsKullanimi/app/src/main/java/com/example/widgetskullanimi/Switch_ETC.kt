package com.example.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.scrollview_calismasi.*
import kotlinx.android.synthetic.main.switch_radiobutton_checkbox_calismasi.*

class Switch_ETC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.switch_radiobutton_checkbox_calismasi)

        switch1.setOnCheckedChangeListener { switch, durum ->
            if(durum){
                Snackbar.make(switch,"Bildirimler Açık",Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(switch,"Bildirimler Kapalı",Snackbar.LENGTH_SHORT).show()
            }
        }

        checkBoxKotlin.setOnCheckedChangeListener { checkBox, durum ->
            if(durum){
                Snackbar.make(checkBox,"Kotlin Seçildi",Snackbar.LENGTH_SHORT).show()
            }
        }
        checkBoxJava.setOnCheckedChangeListener { checkBox, durum ->
            if(durum){
                Snackbar.make(checkBox,"Java Seçildi",Snackbar.LENGTH_SHORT).show()
            }
        }
        radioButtonRealMadrid.setOnCheckedChangeListener { radioButton, durum ->
            if(durum){
                Snackbar.make(radioButton,"Yaşasın Real Mardin seçildi.",Snackbar.LENGTH_SHORT).show()
            }
        }
        radioButtonBarcelona.setOnCheckedChangeListener { radioButton, durum ->
            if(durum){
                Snackbar.make(radioButton,"Yaşasın Barcelona seçildi.",Snackbar.LENGTH_SHORT).show()
            }
        }

        button16.setOnClickListener{
            val bildirim = switch1.isChecked
            val kotlin = checkBoxKotlin.isChecked
            val java = checkBoxJava.isChecked

            val radio = radioGroup.checkedRadioButtonId
            val s = findViewById(radio) as RadioButton

            val yazi = s.text
            Snackbar.make(it,yazi,Snackbar.LENGTH_SHORT).show()

        }

    }
}