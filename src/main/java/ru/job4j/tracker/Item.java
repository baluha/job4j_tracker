package ru.job4j.tracker;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private String name;
    private int id;
    private LocalDateTime created = LocalDateTime.now();

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Item(String name, int id) {
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
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id
                && Objects.equals(name, item.name)
                && Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, created);
    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }
}