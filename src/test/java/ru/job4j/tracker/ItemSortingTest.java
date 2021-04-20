package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemSortingTest {
    @Test
    public void ascending() {
        Item item1 = new Item("a", 1);
        Item item2 = new Item("b", 2);
        Item item3 = new Item("c", 3);
        List<Item> item = Arrays.asList(
               item1, item3, item2
        );
        List<Item> rsl = Arrays.asList(
                item1, item2, item3
        );
        Collections.sort(item, new ItemSortedAscending());
        assertThat(item, is(rsl));
    }

    @Test
    public void descending() {
        Item item1 = new Item("a", 1);
        Item item2 = new Item("b", 2);
        Item item3 = new Item("c", 3);
        List<Item> item = Arrays.asList(
                item1, item3, item2
        );
        List<Item> rsl = Arrays.asList(
                item3, item2, item1
        );
        Collections.sort(item, new ItemSortedDescending());
        assertThat(item, is(rsl));
    }

}