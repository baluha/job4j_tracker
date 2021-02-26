package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calc(){
        Fact.calc(-3);
    }

    @Test
    public void oneMoreCalc(){
        Fact.calc(3);
        int rsl = 3;
        assertThat(rsl, is(3));
    }
}