package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var number:String = ""
        var number1:Int = -1
        button1.setOnClickListener {
            number+="1"
            textView_result.setText(number)
        }
        button2.setOnClickListener {
            number+="2"
            textView_result.setText(number)
        }
        button3.setOnClickListener {
            number+="3"
            textView_result.setText(number)
        }
        button4.setOnClickListener {
            number+="4"
            textView_result.setText(number)
        }
        button5.setOnClickListener {
            number+="5"
            textView_result.setText(number)
        }
        button6.setOnClickListener {
            number+="6"
            textView_result.setText(number)
        }
        button7.setOnClickListener {
            number+="7"
            textView_result.setText(number)
        }
        button8.setOnClickListener {
            number+="8"
            textView_result.setText(number)
        }
        button9.setOnClickListener {
            number+="9"
            textView_result.setText(number)
        }
        button0.setOnClickListener {
            number+="0"
            textView_result.setText(number)
        }
        buttonClear.setOnClickListener {
            textView_result.setText("")
            number = ""
            number1 = 0
        }
        buttonPlus.setOnClickListener {
            number1 = textView_result.text.toString().toInt()
            number = ""
        }

        buttonEqual.setOnClickListener {
            textView_result.setText((number1 + number.toInt()).toString())
        }
    }
}