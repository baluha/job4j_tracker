package ru.job4j.tracker;


import java.sql.SQLOutput;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                           } else if (select == 1) {
                Item [] item = tracker.findAll(); 
                for (int i = 0; i < item.length; i++) {
                    System.out.println(item[i]);
                }
            }
            else if (select == 2) {
                System.out.println("Enter id : ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name : ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item))
                    System.out.println("Item successfully replaced!");
                else {
                    System.out.println("Item replace error");
                }
            }
            else if (select == 3) {
                System.out.println("=== Delete Item ==="+ System.lineSeparator() +
                "Enter item id : ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete (id)) {
                    tracker.delete(id);
                    System.out.println("Item deleted");
                }
                else {
                    System.out.println("Item not found");
                }
            }
            else if (select == 4) {
                System.out.println("===Find item by Id===" + System.lineSeparator() +
                        "Enter item id : ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                }
                else System.out.println("Item not found");
            }
            else if (select == 5) {
                System.out.println("===Find items by name===" + System.lineSeparator() +
                        "Enter item name : ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}