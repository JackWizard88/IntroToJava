package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /*
    блок настроек игры
     */

    private static char[][] map;
    private static int SIZE = 5;

    private static final char DOT_EMPTY = '•';  //empty space
    private static final char DOT_X = 'X';     //X
    private static final char DOT_O = 'O';      //O

    private static final boolean SILLY_MODE = false;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        setSIZE();
        initMap();
        printMap();

        while (true) {
            humanTurn();                    //human turn
            if(isEndGame(DOT_X)) break;

            computerTurn();                 //computer turn
            if(isEndGame(DOT_O)) break;
        }

        System.out.println("Игра закончена");
        scanner.close();

    }

    //Задаем размерность поля
    public static void setSIZE() {
        do{
            System.out.print("Введите желаемый размер игрового поля (3...9): ");
            SIZE = scanner.nextInt();
        } while (SIZE < 3 || SIZE > 9 );

    }

    //Создаем игровое поле размерностью SIZE
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for(int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //human1 Turn
    public static void humanTurn() {
        int x, y;

        do{
            System.out.print("Введите координаты ячейки через пробел: ");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        //check coordinate is in field
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }

        //check if cell is empty
        if( map[y][x] != DOT_EMPTY) {
            result = false;
        }

        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;
         printMap();

         //
        if(checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol +"-ики!");
            result = true;
        }

        if(isMapFull()) {
            System.out.println("Ничья!");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {
        boolean result = true;

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    private static boolean checkWin(char playerSymbol) {

        //проверка выйгрыша горизонтали
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == playerSymbol && map[i][j + 1] == playerSymbol && map[i][j + 2] == playerSymbol)
                    return true;
            }
        }

        //проверка выйгрыша горизонтали
        for (int i = 0; i < SIZE - 2 ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == playerSymbol && map[i + 1][j] == playerSymbol && map[i + 2][j] == playerSymbol)
                    return true;
            }
        }
        //проверка выйгрыша диагонали
        for (int i = 0; i < SIZE - 2 ; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == playerSymbol && map[i + 1][j + 1] == playerSymbol && map[i + 2][j + 2] == playerSymbol)
                    return true;
            }
        }

        //проверка обратной диагонали
        for (int i = 1; i <= SIZE - 2 ; i++) {
            for(int j = 1; j <= SIZE - 2; j++) {
                if (map[i + 1][j - 1] == playerSymbol && map[i][j] == playerSymbol && map[i - 1][j + 1] == playerSymbol) return true;
            }
        }

        return false;
    }

    // Ход компьютера
    private static void computerTurn() {
        int x = -1;
        int y = -1;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            int score; //current value counter
            int maxScore = 0;  // max value counter

            for(int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {

                    if (isCellValid(j, i)) {  //check if cell is empty
                        score = 0;


                        //проверяет все ячейки вокруг набирая очки за соседство со своими ноликами, а так же с Крестиками
                        for (int k = i - 1; k < i + 1; k++) {
                            for (int l = j - 1; l < j + 1; l++){
                                if (checkCellScore(k, l)) score++;
                            }
                        }

                        //если очков больше чем на макс, то перезаписываем более выгодные координаты
                        if (score >= maxScore) {
                            maxScore = score;
                            x = j;
                            y = i;
                        }
                    }
                }
            }

            if (maxScore == 0) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (!isCellValid(x, y));
            }

        }

        System.out.println("Компьютер ставит Нолик в ячейку (" + (y + 1) + ", " + (x + 1)+ ")");
        map[y][x] = DOT_O;
    }

    //проверяем существует ли клетка, и если да, то есть ли в ней "О"
    private static boolean checkCellScore(int y, int x) {

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_O;
    }

}
