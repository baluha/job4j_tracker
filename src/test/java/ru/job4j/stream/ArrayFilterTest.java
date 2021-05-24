package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayFilterTest {
    @Test
    public void arraySort () {
        List<Integer> exemple = List.of(15, 10, 3, -9, 4, -44);
        List<Integer> rsl = ArrayFilter.positiveFilter(exemple);
        List<Integer> exp = List.of(15, 10, 3, 4);
        assertThat(rsl ,is(exp));
    }
}