package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
    public Item findByName(String key) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if(item.getName() == key) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
    public Item[] findAll() {
         Item[] AllItems = new Item[size];
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if(item.getName() != null) {
                AllItems[size++] = item;
            }
        }
      AllItems = Arrays.copyOf(AllItems, size);
        for (int i = 0; i < AllItems.length; i++) {
            ???
        }
        return ???
    }
}