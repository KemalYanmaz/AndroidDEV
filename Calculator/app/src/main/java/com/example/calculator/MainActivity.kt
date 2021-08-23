package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var number:String = ""
        var number1:Double = 0.0
        var operation = ""
        var result=""
        button1.setOnClickListener {
            number+="1"
            textView_result.text = number
        }
        button2.setOnClickListener {
            number+="2"
            textView_result.text = number
        }
        button3.setOnClickListener {
            number+="3"
            textView_result.text = number
        }
        button4.setOnClickListener {
            number+="4"
            textView_result.text = number
        }
        button5.setOnClickListener {
            number+="5"
            textView_result.text = number
        }
        button6.setOnClickListener {
            number+="6"
            textView_result.text = number
        }
        button7.setOnClickListener {
            number+="7"
            textView_result.text = number
        }
        button8.setOnClickListener {
            number+="8"
            textView_result.text = number
        }
        button9.setOnClickListener {
            number+="9"
            textView_result.text = number
        }
        button0.setOnClickListener {
            number+="0"
            textView_result.text = number
        }
        buttonDot.setOnClickListener {
            number+="."
            textView_result.text = number
        }
        buttonClear.setOnClickListener {
            textView_result.text = ""
            number = ""
            number1 = 0.0
        }
        buttonSummation.setOnClickListener {
            number1 = textView_result.text.toString().toDouble()
            number = ""
            operation = "+"
        }
        buttonDivision.setOnClickListener {
            number1 = textView_result.text.toString().toDouble()
            number = ""
            operation = "/"
        }
        buttonMultiplication.setOnClickListener {
            number1 = textView_result.text.toString().toDouble()
            number = ""
            operation = "*"
        }
        buttonSubtraction.setOnClickListener {
            number1 = textView_result.text.toString().toDouble()
            number = ""
            operation = "-"
        }

        buttonEqual.setOnClickListener {
            when(operation){
                "+"->result=(number1 + number.toDouble()).toString()
                "-"->result=(number1 - number.toDouble()).toString()
                "*"->result=(number1 * number.toDouble()).toString()
                "/"->result=(number1 / number.toDouble()).toString()
            }
            val splitResult = result.split(".")
            if(splitResult.get(1).toInt()==0){
                    textView_result.text = splitResult.get(0)
            }else{
                textView_result.text = result.toDouble().toString()
            }
        }
    }
}