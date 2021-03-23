package ru.job4j.list;

import java.util.List;

public class CheckerAhdGetter {
    public static String getElement(List<String> list) {
        String n = list.isEmpty() ? "" : list.get(0);
        return n;
    }
}