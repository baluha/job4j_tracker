package ru.job4j.list;

import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        if(!list.contains(el)){
            return list.subList(0,0);
        }
        else if(list.indexOf(el) == list.lastIndexOf(el)) {
            return list.subList(0, 0);
        }
        else return list.subList(list.indexOf(el), list.lastIndexOf(el));
    }
}