package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal domesticAnimal = new DomesticAnimal();
        Animal[] animals = new Animal[]{animal, domesticAnimal};
        for (Animal a : animals) {
            a.sound();
        }
    }
}