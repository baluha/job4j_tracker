package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction{

    @Override
    public String name() {
        return "===Find item by Id===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            return true;
        }
        else System.out.println("Item not found");
        return true;
    }
}

