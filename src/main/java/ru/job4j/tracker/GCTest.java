package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.util.List;

public class GCTest {

    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        for (int i = 0; i < 100_0000; i++) {
            memTracker.add(new Item("item " + i));
        }
        List<Item> items = memTracker.findAll();
        for (int i = 0; i < items.size(); i++) {
            memTracker.delete(items.get(i).getId());
        }
    }
}
