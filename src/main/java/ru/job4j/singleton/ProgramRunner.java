package ru.job4j.singleton;

public class ProgramRunner {
    public static void main(String[] args) {
        System.out.println(ProgramLogger.getProgramLogger().toString());
        ProgramLogger.getProgramLogger().addInfo("One");
        ProgramLogger.getProgramLogger().addInfo("Two");
        ProgramLogger.getProgramLogger().addInfo("Three");
        ProgramLogger.getProgramLogger().showLog();
    }
}
