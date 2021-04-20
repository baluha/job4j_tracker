package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private  final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        if (tracker.delete(id)) {
            out.println("Item deleted");
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
