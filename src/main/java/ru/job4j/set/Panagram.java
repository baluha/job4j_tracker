package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Panagram {
    public static boolean checkString(String s) {
        String str = s.replaceAll(" ", "");
        str.toLowerCase();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(str.split("")));
        return set.size() == 26;
    }
}