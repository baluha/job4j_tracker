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
    public void whenExponentialАFunc() {
        List<Double> rsl = Diapason.diapason(4, 8, x -> Math.pow(x, x));
        List<Double> exp = Arrays.asList(256.0, 3125.0, 46656.0, 823543.0);
        assertThat(rsl, is(exp));
    }
}