package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFilter {
    public static List<Integer> positiveFilter(List<Integer> incomeList) {
        return incomeList.stream().filter(income -> income > 0).collect(Collectors.toList());
    }
}
