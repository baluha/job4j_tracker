package ru.job4j.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Red {
    public static void main(String[] args) {

        // сюда сложим элементы
        Supplier<List<Integer>> supplier = LinkedList::new;
        // говорим, как добавлять элементы
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        // не вдаемся в подробности. Просто нужно
        BinaryOperator<List<Integer>> merger = (xs, ys) -> {
            xs.addAll(ys);
            return xs;
        };
        // это функция, которая обработает наш список после сборки
// здесь вся логика
        Function<List<Integer>, Integer> function = (ns) -> {
            int number = 100;
            for (Integer n : ns) {
                number /= n;
            }
            return number;
        };

        Integer result = List.of(4, 5).stream()
                .collect(Collector.of(supplier, consumer, merger, function));

        System.out.println(result);
    }

}
