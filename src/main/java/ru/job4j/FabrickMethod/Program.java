package ru.job4j.FabrickMethod;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = crateDeveloper("java");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory crateDeveloper(String specialty) {
        if (specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        }
        else if (specialty.equalsIgnoreCase("cpp")) {
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException(specialty + "its unknown specialty");
        }

    }
}
