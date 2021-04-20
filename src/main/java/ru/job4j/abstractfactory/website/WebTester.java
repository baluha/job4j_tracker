package ru.job4j.abstractfactory.website;

import ru.job4j.abstractfactory.Tester;

public class WebTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Testing website....");
    }
}
