package ru.job4j.oop;

import java.time.LocalDate;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, String education, LocalDate birthday) {
        super(name, surname, education, birthday);
    }

    public void haveSurgery(Patient patient) {

    }
}
