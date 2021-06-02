package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrtFunc() {
        List<Double> rsl = Diapason.diapason(4, 8, x -> x * x);
        List<Double> exp = Arrays.asList(16D, 25D, 36D, 49D);
        assertThat(rsl, is(exp));
    }

    @Test
    public void whenExpFunc() {
        List<Double> rsl = Diapason.diapason(4, 8, x -> Math.pow(2, x));
        List<Double> exp = Arrays.asList(16.0, 32.0, 64.0, 128.0);
        assertThat(rsl, is(exp));
    }
}