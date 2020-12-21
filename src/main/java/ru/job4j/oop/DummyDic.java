package ru.job4j.oop;

public class DummyDic {
    public static String engToRus(String eng) {
        String rus = "Неизвестное слово " + eng;
        return rus;
    }

    DummyDic first = new DummyDic(engToRus("lalala");
}
