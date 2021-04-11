package ru.job4j.tracker;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareTo() {
        List <Item> item = Arrays.asList(
                new Item("a", 1),
                new Item("c", 3),
                new Item("b", 2)
        );
        List <Item> rsl = Arrays.asList(
                new Item("a", 1),
                new Item("b", 2),
                new Item("c", 3)
        );
        Collections.sort(item);
        assertThat(item, is (rsl));
    }
    @Test
    public void comparator() {
        List <Item> item = Arrays.asList(
                new Item("a", 1),
                new Item("c", 3),
                new Item("b", 2)
        );
        List <Item> rsl = Arrays.asList(
                new Item("c", 3),
                new Item("b", 2),
                new Item("a", 1)
        );
        Collections.sort(item, Collections.reverseOrder());
        assertThat(item, is (rsl));
    }
}