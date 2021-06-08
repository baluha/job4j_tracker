package ru.job4j.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }


    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_2, V_3, V_4, V_5, V_6, V_7, V_8, V_9, V_10, JACK, QUEEN, KING, ACE, JOKER
    }

    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        Stream.of(suits)
                .flatMap(suit -> Stream.of(values)
                        .map(value -> suit + " " + value))
                .forEach(System.out::println);
    }
}