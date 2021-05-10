package ru.job4j.list;

import java.util.Comparator;

public class AlphabetAscending implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
