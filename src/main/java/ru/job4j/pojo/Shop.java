package ru.job4j.pojo;

import ru.job4j.oop.Product;

public class Shop {
    public static int indexOfNull(Product[] products){
        int rsl = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
           rsl = i;
                break;
            }
        }
        return rsl;
    }
}