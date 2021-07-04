package ru.job4j.list;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        int el, rsl = 0;
        for (int i = 0; i < count; i++) {
            el = (int) Math.pow(denominator, i);
            rsl += el;
        }
        return rsl;
    }
}