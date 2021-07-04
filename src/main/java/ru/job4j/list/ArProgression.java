package ru.job4j.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
     int sum = 0;
     int currDef = data.get(1) - data.get(0);
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i + 1) - data.get(i) == currDef) {
            sum += data.get(i);
                currDef = data.get(i + 1) - data.get(i);
            } else {
                return 0;
                }
        }
        sum += data.get(data.size() - 1);
        return sum;
        }
}