package ru.job4j.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArProgressionTest {
    @Test
    public void checkDataIsNotNull() {
        List<Integer> data = List.of(
                1, 6, 11, 16, 21,
                26, 31, 36, 41, 46
        );
        int rsl = ArProgression.checkData(data);
        assertThat(rsl, is(235));
    }

    @Test
    public void checkDataIsNull() {
        List<Integer> data = List.of(
                1, 6, 11, 15, 21,
                26, 31, 36, 41, 46
        );
        int rsl = ArProgression.checkData(data);
        assertThat(rsl, is(0));
    }

    @Test
    public void checkDataIs() {
        List<Integer> data = List.of(
                4, 8, 12, 16, 20, 24, 28, 32
        );
        int rsl = ArProgression.checkData(data);
        assertThat(rsl, is(144));
    }
}