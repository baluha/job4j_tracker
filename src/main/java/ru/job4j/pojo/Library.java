package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 431);
        Book book2 = new Book("SomeBook", 215);
        Book book3 = new Book("Buratino", 112);
        Book book4 = new Book("Thinking of java", 1115);
        Book[] bk = new Book[4];
        bk[0] = book1;
        bk[1] = book2;
        bk[2] = book3;
        bk[3] = book4;
        for (int i = 0; i < bk.length; i++) {
            Book book = bk[i];
            System.out.println(book.getName() + " - " + book.getPageQuantity());
        }
        for (int i = 0; i < bk.length; i++) {
            Book book = bk[i];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPageQuantity());
            }

        }
    }
}