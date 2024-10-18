package Lesson7;

import javax.swing.*;

public class Game {
    private GameBoard board;                                    //GameBoard link
    private GamePlayer[] gamePlayers = new GamePlayer[2];       //players array
    private byte PlayersTurn = 0;                               //turn

    public Game() {
        this.board = new GameBoard(this);
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
    }

    // pass turn Method
    void passTurn(){
        if (PlayersTurn == 0) PlayersTurn = 1;
        else PlayersTurn = 0;
    }

    // current player getter
    GamePlayer getCurrentPlayer() {
        return gamePlayers[PlayersTurn];
    }

    //setter
    void setCurrentPlayer(byte playersTurn) {
        this.PlayersTurn = playersTurn;
    }

    // popUp messages
    void showMessage(String text) {
        JOptionPane.showMessageDialog(board, text);
    }
}
