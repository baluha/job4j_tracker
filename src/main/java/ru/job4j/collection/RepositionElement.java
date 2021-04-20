package ru.job4j.collection;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        String lastEl = list.remove(list.size() - 1);
        if (list.size() - 1 >= index) {
            list.set(index, lastEl);
        }
        return list;
    }
}