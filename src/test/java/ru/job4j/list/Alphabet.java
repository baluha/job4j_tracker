package ru.job4j.list;

import java.util.*;

public class Alphabet {
    public static String reformat(String s) {
    List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
    Collections.sort(list);
    StringBuilder builder = new StringBuilder();
        for (String value: list) {
            builder.append(value);
        }
        return builder.toString();
    }
}