package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   val game = TicTacToeGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button00.setOnClickListener {
            pressed(0,0,it)
        }
        button01.setOnClickListener {
            pressed(0,1,it)
        }
        button02.setOnClickListener {
            pressed(0,2,it)
        }
        button10.setOnClickListener {
            pressed(1,0,it)
        }
        button11.setOnClickListener {
            pressed(1,1,it)
        }
        button12.setOnClickListener {
            pressed(1,2,it)
        }
        button20.setOnClickListener {
            pressed(2,0,it)
        }
        button21.setOnClickListener {
            pressed(2,1,it)
        }
        button22.setOnClickListener {
            pressed(2,2,it)
        }

        button.setOnClickListener {
            game.resetGame()
            clearTable()

        }
    }
    fun clearTable(){
        button00.text=""
        button01.text=""
        button02.text=""
        button10.text=""
        button11.text=""
        button12.text=""
        button20.text=""
        button21.text=""
        button22.text=""
        game_state_textview.text=""
    }
    fun pressed(row:Int,col:Int,it:View){
        game.pressButtonAt(row,col)
        (it as Button).text=game.stringForButtonAt(row,col)
        game_state_textview.text=game.stringForGameState()
    }
}