package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

public class GCTest {

    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        for (int i = 0; i < 40_000; i++) {
            memTracker.add(new Item("item " + i));
        }
    }
}
