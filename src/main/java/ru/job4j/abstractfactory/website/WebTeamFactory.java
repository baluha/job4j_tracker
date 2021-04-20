package ru.job4j.abstractfactory.website;

import ru.job4j.abstractfactory.Dev;
import ru.job4j.abstractfactory.ProjectTeamFactory;
import ru.job4j.abstractfactory.Tester;

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
