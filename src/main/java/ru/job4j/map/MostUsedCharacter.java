package ru.job4j.map;

import java.util.Map;
import java.util.TreeMap;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {

        str = str.replaceAll("\\s+", "");
        str = str.toLowerCase();
        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c: ch) {
            map.computeIfPresent(c, (key, val) -> val + 1);
            map.putIfAbsent(c, 1);
        }

        int maxCount = 0;
        char rsl = ' ';
        for (char c: map.keySet()) {
            if (maxCount < map.get(c)) {
                rsl = c;
                maxCount = map.get(c);
            }
        }
        return rsl;
    }
}