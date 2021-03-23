package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {

    private  final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
       return  "=== Showing all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> item = tracker.findAll();
        for (Item items : item) {
            out.println(items);
        }
        return true;
    }
}
