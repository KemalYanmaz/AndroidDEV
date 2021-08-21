package com.example.tictactoe

import android.content.Context
import android.content.ContextWrapper

class TicTacToeGame(base: Context?) : ContextWrapper(base) {

    private var board:Array<Array<Mark>> = Array(NUM_ROWS){ Array(NUM_COLUMNS){Mark.MARK_NONE} }
    var gameState:GameState = GameState.X_TURN

    var playerX = 0
    var playerO = 0
    companion object{
        val NUM_ROWS=3
        val NUM_COLUMNS=3
    }

    enum class Mark{
        MARK_NONE,
        MARK_X,
        MARK_O
    }

    enum class GameState{
        X_TURN,
        O_TURN,
        X_WINS,
        O_WINS,
        TIE_GAME
    }

    init {
        resetGame()
    }

    fun getBoard():Array<Array<Mark>>{
        return this.board
    }
    fun isBoardFull():Boolean{
        for(row in 0 until NUM_ROWS){
            for(col in 0 until NUM_COLUMNS){
                if(board[row][col]==Mark.MARK_NONE){
                    return false
                }
            }
        }
        return true
    }

    fun resetGame(){
        board = Array(NUM_ROWS){ Array(NUM_COLUMNS){Mark.MARK_NONE} }
        gameState = GameState.X_TURN
    }

    fun stringForButtonAt(row:Int,column:Int):String{
        if(row in 0 until NUM_ROWS && column in 0 until NUM_COLUMNS){
            val value = board[row][column]
            if(value==Mark.MARK_X){
                return "X"
            }
            if(value==Mark.MARK_O){
                return "O"
            }
        }
        return ""
    }

    fun pressButtonAt(row:Int,column:Int){
        if(row !in 0 until NUM_ROWS || column !in 0 until NUM_COLUMNS){
            return
        }

        if(board[row][column]!=Mark.MARK_NONE){
            return
        }

        if(gameState==GameState.X_TURN){
            board[row][column] = Mark.MARK_X
            if(!checkForWin(Mark.MARK_X))
            gameState=GameState.O_TURN
        }else if(gameState==GameState.O_TURN){
            board[row][column] = Mark.MARK_O
            if(!checkForWin(Mark.MARK_O))
            gameState=GameState.X_TURN
        }
        if(isBoardFull()){
            if(checkForWin(Mark.MARK_X)){
                gameState=GameState.X_WINS
            }
            else if(checkForWin(Mark.MARK_O)){
                gameState=GameState.O_WINS
            }else{
                gameState=GameState.TIE_GAME
            }
        }
    }

    private fun checkForWin(mark:Mark):Boolean{
        if(didVerticalWin(mark)||didDiagonalWin(mark)||didHorizontalWin(mark)||didReverseDiagonalWin(mark)){
            makeWinner()
            return true
        }
        return false
    }

    private fun makeWinner(){
        if(gameState==GameState.X_TURN){
            gameState=GameState.X_WINS
            playerX++
        }else if(gameState==GameState.O_TURN){
            gameState=GameState.O_WINS
            playerO++
        }
    }
    private fun didVerticalWin(mark:Mark):Boolean{
        var win=true
        for(col in 0 until NUM_COLUMNS){
            win=true
            for(row in 0 until NUM_ROWS){
                win=win&&(board[row][col]==mark)
            }
            if(win){
                return win
            }
        }
        return win
    }

    private fun didHorizontalWin(mark:Mark):Boolean{
        var win=true
        for(row in 0 until NUM_ROWS){
            win = true
            for(col in 0 until NUM_COLUMNS){
                win=win&&(board[row][col]==mark)
            }
            if(win){
                return win
            }
        }
        return win
    }

    private fun didDiagonalWin(mark:Mark):Boolean{
        if(NUM_COLUMNS==NUM_ROWS){
            var win = true
            for(row in 0 until NUM_COLUMNS){
                win=win&&(board[row][row]==mark)
            }
            return win
        }
        return false
    }

    private fun didReverseDiagonalWin(mark:Mark):Boolean{
        if(NUM_COLUMNS== NUM_ROWS){
            var win = true
            for(row in 0 until NUM_COLUMNS){
                win=win&&(board[row][NUM_COLUMNS-row-1]==mark)
            }
            return win
        }
        return false
    }

    fun stringForGameState(): String {
        return when(gameState){
            GameState.X_TURN->baseContext.getString(R.string.x_turn)
            GameState.O_TURN->baseContext.getString(R.string.o_turn)
            GameState.X_WINS->baseContext.getString(R.string.x_wins)
            GameState.O_WINS->baseContext.getString(R.string.o_wins)
            GameState.TIE_GAME->baseContext.getString(R.string.tie_game)
        }
    }
}