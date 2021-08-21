package com.example.tictactoe

import org.junit.Test

import org.junit.Assert.*

/**
 * Unit test for TicTacToe, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SimplyTicTacToeGameTest {
    @Test
    fun boardIsReset() {
        val game = TicTacToeGame()
        for(row in 0 until TicTacToeGame.NUM_ROWS){
            for(column in 0 until TicTacToeGame.NUM_COLUMNS){
                assertEquals("",game.stringForButtonAt(row,column))
            }
        }
        assertEquals(TicTacToeGame.GameState.X_TURN,game.gameState)
    }

    @Test
    fun pressRegisters(){
        val game = TicTacToeGame()
        game.pressButtonAt(1,1)
        assertEquals("X",game.stringForButtonAt(1,1))
        assertEquals(TicTacToeGame.GameState.O_TURN,game.gameState)
        game.pressButtonAt(1,1)
        assertEquals(TicTacToeGame.GameState.O_TURN,game.gameState)
        game.pressButtonAt(1,2)
        assertEquals(TicTacToeGame.GameState.X_TURN,game.gameState)

    }

    @Test
    fun ta(){
        val game = TicTacToeGame()
        game.pressButtonAt(0,0)
        game.pressButtonAt(1,1)
        game.pressButtonAt(0,1)
        game.pressButtonAt(1,2)
        game.pressButtonAt(0,2)
        assertEquals(TicTacToeGame.GameState.X_WINS,game.gameState)
    }

    @Test
    fun isFull(){
        val game=TicTacToeGame()
        game.pressButtonAt(0,0)
        game.pressButtonAt(0,1)
        game.pressButtonAt(0,2)
        game.pressButtonAt(1,1)
        game.pressButtonAt(1,0)
        game.pressButtonAt(2,0)
        game.pressButtonAt(1,2)
        game.pressButtonAt(2,2)
        game.pressButtonAt(2,1)

        assertEquals(true,game.isBoardFull())
    }
}