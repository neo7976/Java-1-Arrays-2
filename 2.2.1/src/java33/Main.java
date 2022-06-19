package java33;
//TODO Поворачиваем всегда новую матрицу

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;
    public static final int TURN = 90;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        int values = 0;
        int degree = 0;

        int[][] colorsNew = colors;
        int[][] rotateColors = new int[SIZE][SIZE];

        while (true) {

            printMatrix(colorsNew, "Матрица для поворота: ");
            System.out.println("Введите угол поворота по часовой стрелке 90, 180, 270,360 или end для завершения программы");
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end"))
                break;
            switch (Integer.parseInt(inputStr)) {
                case 0:
                    printMatrix(colors, "Матрица не была повернута: ");
                    break;
                case 90:
                    setTurn(colorsNew, rotateColors, 90);
                    break;
                case 180:
                    setTurn(colorsNew, rotateColors, 180);
                    break;
                case 270:
                    setTurn(colorsNew, rotateColors, 270);
                    break;
                case 360:
                    printMatrix(colors, "Матрица после поворота равна исходной: ");
                    break;
                default:
                    System.out.println("Вы ввели неверный угол");
                    continue;
            }
            values++;
            degree += Integer.parseInt(inputStr);
        }
        System.out.println("Вы повернули матрицу " + values + " раз(а) на " + degree + " градусов.");
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
    public static void setTurn(int[][] matrixStart, int[][] matrixEnd, int angle) {
        for (int z = 0; z < (angle / TURN); z++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    matrixEnd[i][j] = matrixStart[SIZE - j - 1][i];
                }
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    matrixStart[i][j] = matrixEnd[i][j];
                }
            }
        }
        printMatrix(matrixStart, "Матрица после поворота:");
    }

}

