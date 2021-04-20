package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private  final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
       return "=== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id : ");
        String name = input.askStr("Enter name : ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Item successfully replaced!");
        } else {
            out.println("Item replace error");
        }
        return true;
    }
}
