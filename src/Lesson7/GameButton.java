package Lesson7;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int gameButtonIndex, GameBoard currenGameBoard) {
        this.buttonIndex = gameButtonIndex;
        this.board = currenGameBoard;

        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;

        setSize(currenGameBoard.cellSize - 5, currenGameBoard.cellSize - 5);
        setFont(new Font("Courier new", Font.BOLD, 32));
        setBackground(Color.DARK_GRAY);
        setForeground(new Color(200,105,15));
        addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    public GameBoard getBoard() {
        return board;
    }
}
