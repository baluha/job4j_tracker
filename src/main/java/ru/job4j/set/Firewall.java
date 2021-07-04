package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(s.split(" ")));
        int rsl = set.size() + words.size();
        set.addAll(words);
        int exp = set.size();
        if (rsl == exp) {
            return "Вы сделали правильный выбор!";
        } else {
            return "Выберите другую статью...";
        }
    }
}