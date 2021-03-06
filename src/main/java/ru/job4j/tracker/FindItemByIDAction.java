package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction {

    private  final Output out;

    public FindItemByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "===Find item by Id===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
            return true;
        } else {
            out.println("Item not found");
        }
        return true;
    }
}

