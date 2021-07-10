package ru.job4j.stream;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class JoiningMethod {
    public static String join(List<String> strings) {
        return strings.stream()
                .collect(
                        Collectors.joining(System.lineSeparator(), "Prefix", "Suffix")
                );
    }

    public static void main(String[] args) {
        StringJoiner expect = new StringJoiner(
                System.lineSeparator(),
                "Prefix",
                "Suffix"
        );
        expect.add("A");
        expect.add("B");
        expect.add("C");
        System.out.println(expect);
    }
}