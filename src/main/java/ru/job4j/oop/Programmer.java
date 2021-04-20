package ru.job4j.oop;

import java.time.LocalDate;

public class Programmer extends Engineer {
    private int hoursWorkDay;
    private int salary;

    public Programmer(String name, String surname, String education, LocalDate birthday) {
        super(name, surname, education, birthday);
    }

    public int getSalary() {
        return salary;
    }

    public int getHoursWorkDay() {
        return hoursWorkDay;
    }

    public void writeCode(Keyboard keyboard) {
    }
}
