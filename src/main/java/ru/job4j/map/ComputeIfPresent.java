package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer i: name.keySet()) {
            name.computeIfPresent(i, (key, value) -> value + " " + surname.get(i));
        }
        return name;
    }
}