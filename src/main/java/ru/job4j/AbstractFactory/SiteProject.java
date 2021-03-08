package ru.job4j.AbstractFactory;


import ru.job4j.AbstractFactory.WebSite.WebTeamFactory;


public class SiteProject  {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebTeamFactory();
        Tester webTester = projectTeamFactory.getTester();
        Dev phpDev = projectTeamFactory.getDev();
        webTester.testCode();
        phpDev.writeCode();
    }
}
