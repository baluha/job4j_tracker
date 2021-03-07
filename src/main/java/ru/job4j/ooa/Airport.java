package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus(4, "A380");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

        Airbus secondAirbus = new Airbus("A320" );
        System.out.println(secondAirbus);
        secondAirbus.printModel();
        secondAirbus.printCountEngine();

    }
}