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

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                           } else if (select == 1) {
                Item [] item = tracker.findAll(); 
                for (int i = 0; i < item.length; i++) {
                    System.out.println(item[i]);
                }
            }
            else if (select == 2) {
                System.out.println("=== Edit Item ====");
                int id = input.askInt("Enter id : ");
                String name = input.askStr("Enter name : ");
                Item item = new Item(name);
                if (tracker.replace(id, item))
                    System.out.println("Item successfully replaced!");
                else {
                    System.out.println("Item replace error");
                }
            }
            else if (select == 3) {
                System.out.println("=== Delete Item ===");
                int id = input.askInt("Enter item id : ");
                if (tracker.delete (id)) {
                    System.out.println("Item deleted");
                }
                else {
                    System.out.println("Item not found");
                }
            }
            else if (select == 4) {
                System.out.println("===Find item by Id===");
                int id = input.askInt("Enter item id : ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                }
                else System.out.println("Item not found");
            }
            else if (select == 5) {
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
            else if (select == 6) {
                run = false;
            }
            else {
                System.out.println("Error, please enter number from 0 to 6");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu." + System.lineSeparator() +
                "0. Add new Item" + System.lineSeparator() +
                "1. Show all items" + System.lineSeparator() +
                "2. Edit item" + System.lineSeparator() +
                "3. Delete item" + System.lineSeparator() +
                "4. Find item by Id" + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit Program");

    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}