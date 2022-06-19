package java33;

import java.util.Scanner;

public class Super {

    public static void main(String[] args) {

        String[] product = {"Хлеб", "Яблоки", "Молоко", "Сыр"};
        int[] price = {10, 56, 85, 54};
        System.out.println("Список возможных покупок:");
        for (int i = 0; i < price.length; i++) {
            System.out.println((i + 1) + ". " + product[i] + " " + price[i] + " руб/шт.");
        }
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int[] productCount = new int[4];
        int[] sumProductCount = new int[4];
        int productNumber = 0;

        while (true) {
            System.out.println("Выберите товар и количество или введите end");
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end"))
                break;
            String[] parts = inputStr.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount[productNumber] += Integer.parseInt(parts[1]);
            sumProductCount[productNumber] = price[productNumber] * productCount[productNumber];
        }
        for (int ss : sumProductCount) {
            sum += ss;
        }
        System.out.println("Ваша корзина:\nНаименование товара   Количество  Цена/за ед.   Общая стоимость");
        for (int i = 0; i < price.length; i++) {
            if (productCount[i]!=0)
                System.out.println(product[i] + "                   " + productCount[i] + "         " + price[i] +
                        "             " + sumProductCount[i]);
        }
        System.out.println("                                                     Итог: " + sum);
    }
}

