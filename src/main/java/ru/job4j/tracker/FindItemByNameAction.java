package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "===Find items by name===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item name : ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Error. Can't find items.");
        }
        else {
            for (int i = 0; i < items.length; i++) {
                System.out.println("Id = " + items[i].getId() + ", name = " + items[i].getName());
            }
        }
        return true;
    }
}
