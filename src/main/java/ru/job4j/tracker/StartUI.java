package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItems(Input input, Tracker tracker) {
        System.out.println("=== Showing all items ===");
        Item [] item = tracker.findAll();
        for (int i = 0; i < item.length; i++) {
            System.out.println(item[i]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id = Integer.valueOf(input.askStr("Enter id : "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item))
            System.out.println("Item successfully replaced!");
        else {
            System.out.println("Item replace error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        if (tracker.delete (id)) {
            System.out.println("Item deleted");
        }
        else {
            System.out.println("Item not found");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        System.out.println("===Find item by Id===");
        int id = Integer.valueOf(input.askStr("Enter item id : "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        }
        else System.out.println("Item not found");
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("===Find items by name===");
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
                System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteItemAction(), new FindItemByIDAction(), new FindItemByNameAction(), new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}