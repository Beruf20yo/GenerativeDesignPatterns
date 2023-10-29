package ru.example.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoggerMain {
    static Logger logger;
    public static void main(String[] args) {
        logger = Logger.getInstance();

        Scanner scanner = new Scanner(System.in);
        logger.log("Созздаём объект Scanner для приёма сообщений пользователя");

        System.out.println("Введите длину списка: ");
        logger.log("Просим пользователя ввести длину списка");

        String input = scanner.nextLine();
        int listSize = Integer.parseInt(input);
        logger.log("Сохраняем длину списка");

        System.out.println("Введите максимальное число: ");
        logger.log("Просим пользователя ввести максимальное число, которое может быть в списке");

        input = scanner.nextLine();
        int maxNumber = Integer.parseInt(input);
        logger.log("Сохраняем максимальное число, которое может быть в списке");


        List<Integer> list = new ArrayList<>();
        logger.log("Создаём список список list");

        while (listSize > 0){

            int num = (int) (Math.random() * maxNumber);
            logger.log("Создаём число " + num);

            list.add(num);
            logger.log("Сохраняем число в список");

            listSize--;
            logger.log("Уменьшаем счётчик цикла");
        }
        System.out.println("Список создан");
        logger.log("Сообщаем пользователю, что список создан");

        list.forEach(System.out::println);
        logger.log("Выводим элементы списка построчно");

        System.out.println("Введите число для фильтрации списка");
        logger.log("Просим пользователя ввести число для фильтрации списка");

        input = scanner.nextLine();
        int f = Integer.parseInt(input);
        logger.log("Сохраняем число для фильтрации");

        Filter filter = new Filter(f);
        logger.log("Создаём объект класса Filter и передаём ему число для фильрации");

        List<Integer> filtered = filter.filterOut(list);
        logger.log("Создаём список, где будет храниться уже отфильтрованный начальный list");

        filtered.forEach(System.out::println);
        logger.log("Выводим элементы списка построчно");

    }
}
