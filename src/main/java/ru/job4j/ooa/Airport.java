package ru.job4j.ooa;

public final class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus( "A380");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine(airbus.getName());

        Airbus secondAirbus = new Airbus("A320" );
        System.out.println(secondAirbus);
        secondAirbus.printModel();
        secondAirbus.printCountEngine(secondAirbus.getName());

    }
}