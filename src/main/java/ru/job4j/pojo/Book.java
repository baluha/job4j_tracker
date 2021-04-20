package ru.job4j.pojo;

public class Book {
    private String name;
    private int pageQuantity;

    public Book(String name, int pageQuantity) {
        this.name = name;
        this.pageQuantity = pageQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }
}
