package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.sql.SQLException;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        String name = input.askStr("Enter name: ");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Item name is empty");
        }
        Item item = new Item(name);
        tracker.add(item);
        out.println("Item successfully added!");
        return true;
    }
}
