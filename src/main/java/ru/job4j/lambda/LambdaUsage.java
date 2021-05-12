package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<Attachment> cmpText = (left, right) -> {
            System.out.println(right.getName() + "compareTo" + left.getName());
            return right.getName().compareTo(left.getName());
        };

        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("Integer.compare" + (right.getName().length() + ", " + left.getName().length()));
            return Integer.compare(right.getName().length(), left.getName().length());
        };

    }
}
