package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

        public static void ifPresent(int[] data) {
            max(data).ifPresent(val -> System.out.println("Max: " + val));
        }

        private static Optional<Integer> max(int[] data) {
            Optional<Integer> rsl = Optional.empty();
            int max = 0;
            for (int values: data) {
                if (max < values) {
                    max = values;
                    rsl = Optional.of(max);
                }
            }
            return rsl;
        }
    }