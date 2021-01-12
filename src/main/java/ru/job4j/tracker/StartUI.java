package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item("Vasia",1);
        System.out.println(item);
        String datetimeColonPattern = "dd-MM-yyyy HH:mm:ss";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(datetimeColonPattern);
        System.out.println(timeColonFormatter.format(item.getCreated()));


    }

}


