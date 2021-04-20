package ru.job4j.abstractfactory.website;

import ru.job4j.abstractfactory.Dev;

public class PhpDev implements Dev {

    @Override
    public void writeCode() {
        System.out.println("Write code...");
    }
}
