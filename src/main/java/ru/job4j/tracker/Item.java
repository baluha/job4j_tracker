package ru.job4j.tracker;


import java.time.LocalDateTime;

public class Item {
    private String name;
    private int id;
    private LocalDateTime created = LocalDateTime.now();

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }


    public Item(String name, int id){
        this.name = name;
        this.id = id;
    }
    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id+
                ", name='" + name + '\'' +
                '}';
    }
}