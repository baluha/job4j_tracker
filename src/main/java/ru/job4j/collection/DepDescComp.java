package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] dep1 = o1.split("/");
        String[] dep2 = o2.split("/");
        int min = Math.min(dep1.length, dep2.length);
        if (dep1.length == dep2.length) {
            for (int i = 0; i < min; i++) {
                if (dep1[i].compareTo(dep2[i]) != 0) {
                    rsl = dep1[i].compareTo(dep2[i]);
                    break;
                }
            }
        } else {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
