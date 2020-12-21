package ru.job4j.oop;

public class Story {
    public static void main(String[] args) {
Ball ball = new Ball();
Hare hare = new Hare();
Wolf wolf = new Wolf();
Fox fox = new Fox();
hare.tryToEat(ball);
wolf.tryToEatToo(ball);
fox.eat(ball);
ball.toBeEating(fox);
    }
}
