package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
       return "=== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        String name = input.askStr("Enter name : ");
        Item item = new Item(name);
        if (tracker.replace(id, item))
            return true;
        else {
           return false;
        }
    }
}
