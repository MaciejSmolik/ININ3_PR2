package com.ratengut72;

import com.ratengut72.creatures.Animal;
import com.ratengut72.creatures.Human;
import com.ratengut72.devices.Car;

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

        //task03 & 04
        human.getSalary();
        human.setSalary(-1d);
        human.setSalary(2000d);

        //task05
        car.price = 2500d;
        human.setCar(car);

        //task06
        System.out.println(dog);
        Car vwFirst = new Car("VW", "Polo",1670.0);
        Car vwSecond = new Car("VW", "Polo",1670.0);
        Car vwThird = new Car("VW", "Golf",1670.0);
        System.out.println(vwFirst.equals(vwSecond));
        System.out.println(vwFirst.equals(vwThird));
        System.out.println(vwFirst);
        System.out.println(vwSecond);
    }
}
