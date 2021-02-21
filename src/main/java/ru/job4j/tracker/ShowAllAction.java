package ru.job4j.tracker;

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
        Item [] item = tracker.findAll();
        for (int i = 0; i < item.length; i++) {
            out.println(item[i]);
        }
        return true;
    }
}
