package ru.job4j.man;

public class Manufacture {
    public static Shape create(String name) {
        Shape shape = new EmptyShape();
        if ("triangle".equals(name)) {
            shape = new TriangleShape();
        } else if ("rectangle".equals(name)) {
            shape = new RectangleShape();
        }
        return shape;
    }
}
