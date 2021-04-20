package ru.job4j.abstractfactory.banking;

import ru.job4j.abstractfactory.Dev;

public class JavaDev implements Dev {
    @Override
    public void writeCode() {
        System.out.println("Write java code");
    }
}
