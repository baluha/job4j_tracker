package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        boolean rsl = true;
        Set<String> jack = new HashSet<>();
        for (String value : combination) {
            jack.add(value);
        }
        if (jack.size() > 1) {
            rsl = false;
        }
        return rsl;
    }
}