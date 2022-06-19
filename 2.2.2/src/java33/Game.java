package java33;

// TODO Создание игры крестиики нолики

import java.util.Scanner;

public class Game {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
        Scanner scanner = new Scanner(System.in);
        boolean isCrossTurn = true;

        while (true) {
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            printField(field);
            String input = scanner.nextLine();  // "1 2"
            String[] parts = input.split(" "); // ["1", "2"]
            int x = Integer.parseInt(parts[0]) - 1;
            int y = Integer.parseInt(parts[1]) - 1;
            if (field[x][y] != EMPTY) {
                continue;
            }
            field[x][y] = isCrossTurn ? CROSS : ZERO;

            if (isWin1(field, isCrossTurn ? CROSS : ZERO)) {
                System.out.println("Выиграли " + (isCrossTurn ? "крестики" : "нолики") + "!");
                printField(field);
                break;
            } else
                isCrossTurn = !isCrossTurn;
        }
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static boolean isWin1(char[][] field, char player) {
        int numb = 0;
        //TODO Проверка строк
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == player)
                    numb++;
            }
            if (numb == SIZE)
                return true;
            else
                numb = 0;
        }
        //TODO Проверка столбцов
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == player)
                    numb++;
            }
            if (numb == SIZE)
                return true;
            else
                numb = 0;
        }
        //TODO Проверка крестов (слева на право вниз)
        for (int j = 0; j < SIZE; j++) {
            if (field[j][j] == player)
                numb++;
        }
        if (numb == SIZE)
            return true;
        else
            numb = 0;

        //TODO Проверка крестов (слева на право вверх)
        for (int j = 0; j < SIZE; j++) {
            if (field[SIZE - 1 - j][j] == player)
                numb++;
        }
        if (numb == SIZE)
            return true;
        else
            numb = 0;

        return false;
    }
}

