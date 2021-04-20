package ru.job4j.abstractfactory;


import ru.job4j.abstractfactory.website.WebTeamFactory;

public class SiteProject  {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebTeamFactory();
        Tester webTester = projectTeamFactory.getTester();
        Dev phpDev = projectTeamFactory.getDev();
        webTester.testCode();
        phpDev.writeCode();
    }
}
