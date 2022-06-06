package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class GCDeleteAction implements UserAction {

    private final Output out;

    public GCDeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== DeleteGC item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException, InterruptedException {
        System.out.println("Start deleting!");
        List<Item> items = tracker.findAll();
        int[] size = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            size[i] = items.get(i).getId();
        }
        for (int i = 0; i < size.length; i++) {
            tracker.delete(size[i]);
            Thread.sleep(1);
        }
        List<Item> old = tracker.findAll();
        System.out.println(old.size());
        old.forEach(s -> System.out.println(s.getName()));
        Thread.sleep(10000);
        return true;
    }
}
