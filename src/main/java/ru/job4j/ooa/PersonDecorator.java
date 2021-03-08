package ru.job4j.ooa;

public class PersonDecorator implements Person {

    Person person;

    public PersonDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String DoIt() {
        return person.DoIt();
    }
}
