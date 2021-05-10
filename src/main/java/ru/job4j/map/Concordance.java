package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        String withoutWhitespace = s.replaceAll(" ", "");
        char[] splitS = withoutWhitespace.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < splitS.length; i++) {
            map.putIfAbsent(splitS[i], new ArrayList<>());
            map.get(splitS[i]).add(i);
        }
        return map;
    }
}