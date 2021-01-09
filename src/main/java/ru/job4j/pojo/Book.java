package ru.job4j.pojo;

public class Book {
    private String Name;
    private int PageQuantity;

    public Book(String name, int pageQuantity) {
        Name = name;
        PageQuantity = pageQuantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPageQuantity() {
        return PageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        PageQuantity = pageQuantity;
    }
}
