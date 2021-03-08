package ru.job4j.AbstractFactory;

public interface ProjectTeamFactory {
    Dev getDev();
    Tester getTester();
    PM getPM();
}
