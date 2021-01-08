package ru.job4j.tracker;


public class Item {
    private int id;
    private String name;

    public Item(){

    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Item(int id){
        this.id = id;
    }

    public void setId(int i) {
    }

    public int getId() {
        return id;
    }

    public void setName(String test1) {
    }

    public Object getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}