package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("petrov@mail.ru", "Petrov Petr Petrovich");
        map.put("ivanov@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("sidorov@mail.ru", "Sidorov Sergei Sergeevich");
        for ( String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
