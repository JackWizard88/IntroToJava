package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 3;
    static int cellSize = 150;
    public char gameField[][];
    public char tempField[][];
    private GameButton[] gameButtons;

    private Game game;

    static char nullSymbol = '\u0000';

    public GameBoard(Game currentGame) {
        this.game = currentGame;
        initField();
    }

    private void initField() {
        setBounds( 400, 400, cellSize * dimension, cellSize * dimension);
        setTitle("Крестики-Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        //create NewGameButton panel
        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        newGameButton.setBackground(Color.DARK_GRAY);
        newGameButton.setFont(new Font("Courier new", Font.BOLD, 16));
        newGameButton.setForeground(new Color(200, 105, 15));

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.setSize(cellSize*dimension, 150);

        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.DARK_GRAY);
        gamePanel.setLayout(new GridLayout(dimension, dimension));
        gamePanel.setSize(cellSize*dimension, cellSize*dimension);

        gameField = new char[dimension][dimension];
        tempField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for (int i = 0; i < (dimension*dimension); i++) {
            GameButton fieldButton = new GameButton(i ,this);
            gamePanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    void emptyField() {

        for (int i = 0; i < (dimension*dimension); i++) {
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }
    }

    boolean isTurnable(int x, int y) {

        return gameField[y][x] == nullSymbol;

    }

    public Game getGame() {
        return game;
    }

    void updateGameField(int x, int y) {
        gameField[y][x] =game.getCurrentPlayer().getPlayerSign();
    }

    boolean checkWin(char playerSymbol, char[][] field) {

        return checkWinDiagonals(playerSymbol, field) || checkWinLines(playerSymbol, field);

    }

    boolean isFull(){
        boolean result = true;
        for (int i = 0; i < (dimension*dimension); i++) {
            if(gameField[i / GameBoard.dimension][i % GameBoard.dimension] == nullSymbol){
                result = false;
                break;
            }
        }

        return result;
    }

    private boolean checkWinDiagonals(char playerSymbol, char[][] field){
        boolean leftRight, rightLeft, result;

        leftRight = true;
        rightLeft = true;
        result = false;

        for(int i = 0; i < dimension; i++){
            leftRight &= (field[i][i] == playerSymbol);
            rightLeft &= (field[dimension - i - 1][i] == playerSymbol);
        }

        if(leftRight || rightLeft){
            result = true;
        }

        return result;

    }

    private boolean checkWinLines(char playerSymbol, char[][] field){
        boolean cols, rows, result;

        result = false;

        for(int col = 0; col < dimension; col++){
            cols = true;
            rows = true;

            for(int row = 0; row < dimension; row++){
                cols &= (field[col][row] == playerSymbol);
                rows &= (field[row][col] == playerSymbol);
            }
            if(cols || rows){
                result = true;
                break;
            }
            if(result) {
                break;
            }
        }
        return result;
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }

    public char getFieldChar(int x, int y) {
        return gameField[y][x];
    }
}
