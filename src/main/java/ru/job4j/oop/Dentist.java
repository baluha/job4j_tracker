package ru.job4j.oop;

import java.time.LocalDate;

public class Dentist extends Doctor {

    private int salary;
    private String patientName;

    public Dentist(String name, String surname, String education, LocalDate birthday) {
        super(name, surname, education, birthday);
    }

    public void learn(Equipment equipment) {
    }

    public void human(Patient patient) {
    }
}
