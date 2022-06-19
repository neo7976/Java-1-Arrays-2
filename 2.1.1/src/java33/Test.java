package java33;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        // TODO : Создание массива продуктов
        String[] product = {"Хлеб", "Яблоки", "Молоко"};
        // TODO : Создание массива цен
        int[] price = {100, 200, 300};
        // TODO : Вывод доступных продуктов на экран
        System.out.println("Список возможных покупок:");
        for (int i = 0; i < price.length; i++) {
            System.out.println((i + 1) + ". " + product[i] + " " + price[i] + " руб/шт.");
        }
        // TODO : Возможность ввода пользователем одной строки номера продуктов и количества для добавления в корзину
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int[] productCount = new int[3];
        int[] sumProductCount = new int[3];

        while (true) {
            int productNumber = 0;
            System.out.println("Выберите товар и количество или введите end");
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end"))
                break;
            String[] parts = inputStr.split(" "); // получаем массив
            productNumber = Integer.parseInt(parts[0]) - 1; // номер продукта
            // TODO : произвести суммирование продуктов
            productCount[productNumber] += Integer.parseInt(parts[1]); //количество продуктов
            sumProductCount[productNumber] = price[productNumber] * productCount[productNumber]; //суммарная цена 1 продукта
        }
        for (int ss : sumProductCount) {
            sum += ss;
        }
        // TODO : Вывод покупок, их общую стоимость и количества на экран.
        System.out.println("Ваша корзина:\nНаименование товара   Количество  Цена/за ед.   Общая стоимость");
        for (int i = 0; i < price.length; i++) {
            if (productCount[i]!=0)
            System.out.println(product[i] + "                   " + productCount[i] + "         " + price[i] +
                    "             " + sumProductCount[i]);
        }
        System.out.println("                                                     Итог: " + sum);
    }
}

