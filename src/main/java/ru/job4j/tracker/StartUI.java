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
                    System.out.println("Id = " + item[i].getId() + ", name = " + item[i].getName());
                }
            }
            else if (select == 2) {
                System.out.println("Enter id : ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name : ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);
            }
            else if (select == 3) {
                System.out.println("=== Delete Item ===\n" +
                "Enter item id : ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.findById (id) != null) {
                    tracker.delete(id);
                    System.out.println("Item deleted");
                }
                else {
                    System.out.println("Item not found");
                }
            }
            else if (select == 4) {
                System.out.println("===Find item by Id===\n" +
                        "Enter item id : ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                }
                else System.out.println("Item not found");
            }
            else if (select == 5) {
                System.out.println("===Find items by name===\n" +
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
        System.out.println("Menu.\n" +
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}