package ru.job4j.stream;

public class Car {
    private String name;
    private String model;
    private int weight;
    private String fuel;
    private int maxSpeed;
    private int numSeats;

    @Override
    public String toString() {
        return "Builder{"
                + "name='" + name + '\''
                + ", model='" + model + '\''
                + ", weight=" + weight
                + ", fuel='" + fuel + '\''
                + ", maxSpeed=" + maxSpeed
                + ", numSeats=" + numSeats + '}';
    }

    static class Builder {
        private String name;
        private String model;
        private int weight;
        private String fuel;
        private int maxSpeed;
        private int numSeats;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildWeight(int weight) {
            this.weight = weight;
            return this;
        }

        Builder buildFuel(String fuel) {
            this.fuel = fuel;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildNumSeats(int numSeats) {
            this.numSeats = numSeats;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.name = name;
            car.model = model;
            car.weight = weight;
            car.fuel = fuel;
            car.maxSpeed = maxSpeed;
            car.numSeats = numSeats;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildName("Tesla")
                .buildModel("Model s")
                .buildWeight(2000)
                .buildFuel("Electricity")
                .buildMaxSpeed(300)
                .buildNumSeats(4)
                .build();
        System.out.println(car);
    }
}
