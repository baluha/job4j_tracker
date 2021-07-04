package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(s.split("")));
        return s.length() == set.size();
    }
}
