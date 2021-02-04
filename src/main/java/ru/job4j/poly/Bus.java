package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void toGo() {
        System.out.println("Bus is go to the destination point!");
    }

    @Override
    public void passengers(int pas) {
        int freeplace = 32;
        int emptsits = freeplace - pas;
    }

    @Override
    public double price(int liters) {
        double oneLit = 45;
        double coast = liters * oneLit;
        return coast;
    }
}
