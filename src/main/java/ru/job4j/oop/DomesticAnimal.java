package ru.job4j.oop;

public class DomesticAnimal extends Animal {
    public void liveOnFarm() {
        System.out.println(nameClass + " живет на ферме, приносит пользу.");
    }

    public static void main(String[] args) {
        Animal animal = new DomesticAnimal();
        animal.sound();
    }

}