package ru.job4j;

public class SomeMoving implements InterfaceMove {
    public void move() {
        System.out.println("Чето там");
    }

    @Override
    public void moving() {
        System.out.println("как его");
    }


}
 interface InterfaceMove {
    void moving();
    int a = 9;
}