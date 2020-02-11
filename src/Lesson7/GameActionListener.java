package Lesson7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton button) {
        this.row = row;
        this.cell = cell;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);

            if (board.isFull() ) {
                board.getGame().showMessage("Ничья!");
                board.getGame().passTurn();
                board.emptyField();
            } else if (!board.getGame().getCurrentPlayer().isRealPlayer()) {
                updateByAiData(board);
            }
        } else {
            board.getGame().showMessage("Недопустимый ход");
        }
    }

    private void updateByAiData(GameBoard board) {

        int x = -1, y = -1;                 //coordinates initially illegal
        Random rnd = new Random();          //just Random
        int score;                          //current value of cell counter
        int maxScore = -1;                   //max value of cell counter
        boolean flag = false;

        //make the copy of the field as charArray
        for (int i = 0; i < (GameBoard.dimension*GameBoard.dimension); i++) {
            int a = i / GameBoard.dimension;
            int b = i % GameBoard.dimension;

            board.tempField[a][b] = board.getFieldChar(a, b);
        }

        for (int i= 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++) {

                if (board.isTurnable(i, j)) {
                    board.tempField[i][j] = 'O';
                    if (board.checkWin('O', board.tempField)) {
                        score = 20;     //потому что победить важнее чем не дать победить врагу 20>10
                        if (score > maxScore) {
                            maxScore = score;
                            x = i;
                            y = j;
                        }
                        board.tempField[i][j] = '\u0000';
                        flag = true;
                        break;
                    }
                    board.tempField[i][j] = 'X';
                    if (board.checkWin('X', board.tempField)) {
                        score = 10;
                        if (score > maxScore) {
                            maxScore = score;
                            x = i;
                            y = j;
                        }
                        board.tempField[i][j] = '\u0000';
                    }
                    board.tempField[i][j] = '\u0000';
                }
            }
            if (flag) break;
        }

        if (maxScore == -1) {
            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x, y));
        }

        //Computer makes his move
        // Обновим матрицу игры
        board.updateGameField(x, y);

        // Обновим содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        // Проверить победу
        if (board.checkWin(board.getGame().getCurrentPlayer().getPlayerSign(), board.gameField)) {
            button.getBoard().getGame().showMessage("Компьютер победил!");
            board.getGame().passTurn();
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row, cell);
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin(board.getGame().getCurrentPlayer().getPlayerSign(), board.gameField)) {
            button.getBoard().getGame().showMessage("Вы победили!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }
}
