package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {

    private  final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "===Find items by name===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item name : ");
        List<Item> items = tracker.findByName(name);
        if (items.size() == 0) {
           out.println("Error. Can't find items.");
        }
        else {
            for (Item item : items) {
                out.println("Id = " + item.getId() + ", name = " + item.getName());
            }
        }
        return true;
    }
}
