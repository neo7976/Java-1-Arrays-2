package java33;

//TODO Поворачиваем всегда исходную матрицу

import java.util.Random;
import java.util.Scanner;

public class Final {

    public static final int SIZE = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        int[][] rotateColor = new int[SIZE][SIZE];

        while (true) {
            printMatrix(colors, "Матрица для поворота: ");
            System.out.println("Введите угол поворота по часовой стрелке 90, 180, 270, 360 или end для завершения программы");
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end"))
                break;
            switch (Integer.parseInt(inputStr)) {
                case 0:
                    printMatrix(colors, "Матрица не была повернута: ");
                    break;
                case 90:
                    setTurn90(colors, rotateColor);
                    printMatrix(rotateColor, "Матрица после поворота на 90:");
                    break;
                case 180:
                    setTurn180(colors, rotateColor);
                    printMatrix(rotateColor, "Матрица после поворота на 180:");
                    break;
                case 270:
                    setTurn270(colors, rotateColor);
                    printMatrix(rotateColor, "Матрица после поворота на 270:");
                    break;
                case 360:
                    printMatrix(colors, "Матрица после поворота равна исходной: ");
                    break;
                default:
                    System.out.println("Вы ввели неверный угол");
                    continue;
            }
        }
        System.out.println("До новых встреч!!!");
    }

    public static void printMatrix(int[][] matrix, String phrase) {
        System.out.println(phrase);
        for (int[] number1 : matrix) {
            for (int number2 : number1) {
                System.out.format("%4d", number2);
            }
            System.out.println();
        }
        System.out.println();
    }

    // TODO Поворот нашей матрицы
    public static int[][] setTurn90(int[][] matrixStart, int[][]matrixEnd) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixEnd[i][j] = matrixStart[SIZE - j - 1][i];
            }
        }
        return matrixEnd;
    }

    public static int[][] setTurn180(int[][] matrixStart, int[][] matrixEnd) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixEnd[i][j] = matrixStart[SIZE - i - 1][SIZE-j-1];
            }
        }
        return matrixEnd;
    }

    public static int[][]  setTurn270(int[][] matrixStart, int[][] matrixEnd) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixEnd[i][j] = matrixStart[j][SIZE-i-1];
            }
        }
        return matrixEnd;
    }




}

