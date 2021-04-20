package ru.job4j.abstractfactory;

public interface ProjectTeamFactory {
    Dev getDev();

    Tester getTester();
}
