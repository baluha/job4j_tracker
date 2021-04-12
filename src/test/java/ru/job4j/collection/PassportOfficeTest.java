package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
    @Test
    public void addDuplicate() {
        Citizen citizen = new Citizen("60186363fa", "Vasiliy Vasilievich");
        Citizen citizen1 = new Citizen("60186363fa", "Vasiliy Ivanovich");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        assertThat(office.add(citizen1), is(false));
    }
}