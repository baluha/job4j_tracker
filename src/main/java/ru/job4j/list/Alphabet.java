package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alphabet {
    public static String reformat(String s) {
        StringBuilder str = new StringBuilder();
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        for (char ch: sArray) {
            str.append(ch);
        }
        return str.toString();
    }
}
