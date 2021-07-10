package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {
    public static int get(int[] data, int el) {
        Optional<Integer> rsl = OptionalGetAndIsPresent.indexOf(data, el);
        return rsl.isPresent() ? rsl.get() : -1;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> rsl = Optional.empty();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rsl = Optional.of(i);
                break;
            } else {
                rsl = Optional.empty();
            }
        }
        return rsl;
        }

    }


