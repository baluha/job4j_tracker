package ru.job4j.AbstractFactory.WebSite;

import ru.job4j.AbstractFactory.Dev;
import ru.job4j.AbstractFactory.ProjectTeamFactory;
import ru.job4j.AbstractFactory.Tester;

public class WebTeamFactory implements ProjectTeamFactory {
    @Override
    public Dev getDev() {
        return new PhpDev();
    }

    @Override
    public Tester getTester() {
        return new WebTester();
    }
}
