package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str: strings) {
            String[] first = str.split("");
            String firstString = first[0];
            rsl.putIfAbsent(firstString, new ArrayList<>());
            rsl.get(firstString).add(str);
        }
        return rsl;
    }
}