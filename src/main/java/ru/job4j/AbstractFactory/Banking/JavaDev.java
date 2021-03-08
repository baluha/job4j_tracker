package ru.job4j.AbstractFactory.Banking;

import ru.job4j.AbstractFactory.Dev;

public class JavaDev implements Dev {
    @Override
    public void writeCode() {
        System.out.println("Write java code");
    }
}
