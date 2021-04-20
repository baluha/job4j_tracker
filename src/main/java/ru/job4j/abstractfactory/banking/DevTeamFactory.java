package ru.job4j.abstractfactory.banking;

import ru.job4j.abstractfactory.Dev;
import ru.job4j.abstractfactory.ProjectTeamFactory;
import ru.job4j.abstractfactory.Tester;

public class DevTeamFactory implements ProjectTeamFactory {
    @Override
    public Dev getDev() {
        return new JavaDev();
    }

    @Override
    public Tester getTester() {
        return new JavaTester();
    }
}
