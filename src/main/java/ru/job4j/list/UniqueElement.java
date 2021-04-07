package ru.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        int first = list.indexOf(str);
        int second = list.lastIndexOf(str);
        return first == second && first != -1;
    }
}