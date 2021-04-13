package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        HashSet<Order> ordersSet = new HashSet<>();
        for (Order order : orders) {
            ordersSet.add(order);
        }
        for (Order order : ordersSet) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}