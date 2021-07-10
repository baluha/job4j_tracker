package ru.job4j.comparator;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {
    public static Map<Integer, String> sort(Map<Integer, String> map) {
        Map<Integer, String> sorted = new TreeMap<>(Comparator.reverseOrder());
        sorted.putAll(map);
        return sorted;
    }
}
