package com.ratengut72;

import com.ratengut72.creatures.Animal;
import com.ratengut72.creatures.Human;
import com.ratengut72.devices.Car;
import com.ratengut72.devices.Device;
import com.ratengut72.devices.Phone;

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
        Car car = new Car("VW","Gold",1690.0,2010);

        //task03 & 04
        human.getSalary();
        human.setSalary(-1d);
        human.setSalary(2000d);

        //task05
        car.price = 2500d;
        human.setCar(car);

        //task06
        System.out.println(dog);
        Car vwFirst = new Car("VW", "Polo",1670.0,2010);
        Car vwSecond = new Car("VW", "Polo",1670.0,2010);
        Car vwThird = new Car("VW", "Golf",1670.0,2010);
        System.out.println(vwFirst.equals(vwSecond));
        System.out.println(vwFirst.equals(vwThird));
        System.out.println(vwFirst);
        System.out.println(vwSecond);

        //task07
        Phone phone = new Phone("Xiaomi", "Mi 9",2019);
        Device fiat = new Car("Fiat", "Grande punto", 1430.0, 2010);

        System.out.println(phone);
        System.out.println(fiat);
        phone.turnOn();
        car.turnOn();

        //task08
        Human buyer = new Human("Jacob", "Wooden");
        Human seller = new Human("Cris", "Caren");
        buyer.setCash(2000d);
        seller.setCash(2000d);
        Phone xiaomi = new Phone("Xiaomi", "Mi 9",2019);
        seller.setPhone(xiaomi);
        Car automobile = new Car("Fiat", "Grande punto", 1430.0, 2010);
        seller.setCar(automobile);
        seller.animal = null;
        xiaomi.sell(seller,buyer,950d);
        System.out.println(buyer.getPhone());
        automobile.sell(seller,buyer,1150d);
        System.out.println(buyer.getCar());
        Animal small = new Animal("mouse");
        small.sell(seller,buyer,2d);
        System.out.println(buyer.animal);
    }
}
