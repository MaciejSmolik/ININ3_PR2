package com.ratengut72.creatures;

public class Main {

    public static void main(String[] args) {
        //task 01
        Animal dog = new Animal("dog");
        dog.feed();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.feed();
        Animal mouse = new Animal("mouse");
        mouse.feed();
        mouse.takeForAWalk();
        mouse.takeForAWalk();
        mouse.feed();

        //task02
        Human human = new Human("Karol", "Krawczyk");
        Car car = new Car("VW","Gold",1690.0);
        human.car = car;
    }
}
