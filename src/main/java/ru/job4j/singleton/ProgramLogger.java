package ru.job4j.singleton;
// Для однопоточной среды, что бы сделать для многопоточной,
// нужно прописать synchronized в public static synchronized ProgramLogger getProgramLogger()
public class ProgramLogger {
private static  ProgramLogger programLogger;
private static String logfile = "This is log...\n";

    private ProgramLogger() {

    }

public  static ProgramLogger getProgramLogger() {
    if (programLogger == null) {
        programLogger = new ProgramLogger();
    }
    return programLogger;
}

public void addInfo(String info) {
    logfile += info + "\n";
}

public void showLog() {
    System.out.println(logfile);
}
}
