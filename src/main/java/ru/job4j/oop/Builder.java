package ru.job4j.oop;

import java.time.LocalDate;

public class Builder extends Engineer{
    private int salary;
    private int specialization;

    public Builder(String name, String surname, String education, LocalDate birthday) {
        super(name, surname, education, birthday);
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
    }
    public void build(Material material){

    }
}