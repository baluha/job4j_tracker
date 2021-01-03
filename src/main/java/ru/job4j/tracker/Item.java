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

}