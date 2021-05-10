package ru.job4j.set;

import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String rsl = "Вы сделали правильный выбор!";
        String[] ss = s.split(" ");
        for (String word: words) {
            for (String sWords: ss) {
                if (word.equals(sWords)) {
                    rsl = "Выберите другую статью...";
                    break;
                }
            }
        }
        return rsl;
    }
}