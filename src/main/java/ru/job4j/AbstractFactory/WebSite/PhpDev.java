package ru.job4j.AbstractFactory.WebSite;

import ru.job4j.AbstractFactory.Dev;

public class PhpDev implements Dev
{
    @Override
    public void writeCode() {
        System.out.println("Write code..." );
    }
}
