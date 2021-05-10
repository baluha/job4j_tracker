package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Panagram {
    public static boolean checkString(String s) {
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        String[] chars = s.split("");
        Set<String> fin = new HashSet<>();
        for (String value : chars) {
            fin.add(value);
        }
       return fin.size() == 26;

    }
}