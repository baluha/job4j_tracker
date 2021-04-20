package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicate() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("3bce", "Shoes");
        Order order2 = new Order("3bce", "Shoes");
        Order order3 = new Order("3sfe", "Dress");
        orders.add(order);
        orders.add(order2);
        orders.add(order3);
        HashMap<String, Order> map = OrderConvert.process(orders);
        HashMap<String, Order> expected = new HashMap<>();
        expected.put(order.getNumber(), order);
        expected.put(order3.getNumber(), order3);
        assertThat(map, is(expected));
    }
}