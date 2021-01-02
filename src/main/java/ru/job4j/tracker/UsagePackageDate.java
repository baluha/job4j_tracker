package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now(); // переменной currentDateTime типа LocalDateTime присваиваем значение метода now() класса LocalDateTime
        System.out.println("Текущие дата и время до форматирования: " + currentDateTime); // Выводим в консоль

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  // переменной formatter типа DateTimeFormatter присваиваем значение метода
        // ofPattern класса DateTimeFormatter с аргументами "dd-MM-yyyy HH:mm:ss"
        String currentDateTimeFormat = currentDateTime.format(formatter); // Вот тут не совсем понятно. То есть currentDateTimeFormat типа string, короче не пойму...
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    }
}