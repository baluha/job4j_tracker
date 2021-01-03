package ru.job4j.oop;

import java.time.LocalDate;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education, LocalDate birthday) {
        super(name, surname, education, birthday);
    }
}
