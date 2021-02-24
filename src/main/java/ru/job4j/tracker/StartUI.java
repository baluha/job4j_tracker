package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public void findAllItems(Input input, Tracker tracker) {
        System.out.println("=== Showing all items ===");
        Item [] item = tracker.findAll();
        for (int i = 0; i < item.length; i++) {
            System.out.println(item[i]);
        }
    }

    public void replaceItem(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        int id = Integer.valueOf(input.askStr("Enter id : "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item))
            out.println("Item successfully replaced!");
        else {
            out.println("Item replace error");
        }
    }

    public void deleteItem(Input input, Tracker tracker) {
        out.println("=== Delete Item ===");
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        if (tracker.delete (id)) {
            out.println("Item deleted");
        }
        else {
            out.println("Item not found");
        }
    }

    public void findItemByID(Input input, Tracker tracker) {
        out.println("===Find item by Id===");
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        }
        else out.println("Item not found");
    }

    public void findItemByName(Input input, Tracker tracker) {
       out.println("===Find items by name===");
        String name = input.askStr("Enter item name : ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            out.println("Error. Can't find items.");
        }
        else {
            for (int i = 0; i < items.length; i++) {
                out.println("Id = " + items[i].getId() + ", name = " + items[i].getName());
            }
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
                out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new DeleteItemAction(output),
                new FindItemByIDAction(output),
                new FindItemByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}