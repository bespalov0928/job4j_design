package ru.job4j.chapter002.Io.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chat {
    public static void main(String[] args) {

        String firstParam = args[0];
        String secondParam = args[1];
        List<String> listLog = new ArrayList<>();
        int randomValue;
        //стоп/продолжить/закончить

        //считаем фай ответов в массив
        List<String> listAnswer = readFile(firstParam);
        //создадим массив для записи ответов

        //генерим рандомные ответы
        Random random = new Random();

        //цикл чата
//        while (true) {
//            randomValue = random.nextInt(listAnswer.size() - 1);
//            String answer = listAnswer.get(randomValue);
//            listLog.add(answer);
//            System.out.println(answer);
//        }

        //записываем результат в лог
        //writeFile(listLog, secondParam);

    }

    public static List<String> readFile(String file) {
        List<String> lines = new ArrayList<>();
//        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
//            in.lines().forEach(lines::add);
//        }

        return lines;
    }

    public static void writeFile(List<String> list, String file) {
        //to do

    }


}
