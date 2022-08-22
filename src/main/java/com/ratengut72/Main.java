package com.ratengut72;

import com.ratengut72.creatures.Animal;
import com.ratengut72.creatures.FarmAnimal;
import com.ratengut72.creatures.Human;
import com.ratengut72.creatures.Pet;
import com.ratengut72.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        //task 01
        Animal dog = new Pet("dog","Fafik");
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
        Animal mouse = new Pet("mouse","Mickey");
        mouse.feed();
        mouse.takeForAWalk();
        mouse.takeForAWalk();
        mouse.feed();

        //task02
        Human human = new Human("Karol", "Krawczyk");
        Car car = new Diesel("VW","Gold",2010, 1690.0);

        //task03 & 04
        human.getSalary();
        human.setSalary(-1d);
        human.setSalary(2000d);

        //task05
        car.setPrice(2500d);
        human.setCar(car,0);

        //task06
        System.out.println(dog);
        Car vwFirst = new Diesel("VW", "Polo",2010,1670.0);
        Car vwSecond = new Diesel("VW", "Polo", 2010,1670.0);
        Car vwThird = new Diesel("VW", "Golf", 2010, 1670.0);
        System.out.println(vwFirst.equals(vwSecond));
        System.out.println(vwFirst.equals(vwThird));
        System.out.println(vwFirst);
        System.out.println(vwSecond);

        //task07
        Phone phone = new Phone("Xiaomi", "Mi 9",2019);
        Device fiat = new Diesel("Fiat", "Grande punto", 2010,1430.0);

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
        Car automobile = new Diesel("Fiat", "Grande punto", 2010,1430.0);
        seller.setCar(automobile,0);
        seller.animal = null;
        xiaomi.sell(seller,buyer,950d);
        System.out.println(buyer.getPhone());
        automobile.sell(seller,buyer,1000d);
        System.out.println(buyer.getCar(0));
        Animal small = new Pet("mouse", "Miki");
        small.sell(seller,buyer,2d);
        System.out.println(buyer.animal);

        //task09
        FarmAnimal farm = new FarmAnimal("pig", 345d, "Piggy");
        farm.feed();
        System.out.println(farm);
        farm.feed(29d);
        System.out.println(farm);
        farm.beEaten();
        System.out.println(farm);
        farm.feed();

        //task10
        xiaomi.installAnApp("Google Maps");
        xiaomi.installAnApp("Google Maps", "1.0");
        xiaomi.installAnApp("Google Maps", "1.0", "http://8.8.8.8:80");
        xiaomi.installAnApp(List.of("Google Maps", "Facebook", "Instagram"));
        xiaomi.installAnApp(new URL("HTTP", "8.8.8.8", "/maps"));

        //task11
        Car f = new Diesel("Fiat", "Grande Punto", 2010,1240.0,2000d);
        Car g = new Diesel("VW", "GGolf",2019,1540.0,1500d);
        Car a = new Diesel("Fiat", "Grande Punto",2022 ,1940.0,1000d);
        Car t = new Electric("Tesla", "Model S", 2019,2240.0,3000d);
        Human sell = new Human("F", "B",6);
        sell.setSalary(1000000d);
        sell.setCar(f,0);
        sell.setCar(null,1);
        sell.setCar(g,2);
        sell.setCar(a,3);
        sell.setCar(null,4);
        sell.setCar(t,5);
        sell.sortCarsFromOldestToNewest();
        System.out.println(sell);
        System.out.println(sell.calculateGarageValue());

        //task12
        Human buy = new Human("B", "B", 10);
        buy.setCash(10000d);
        f.sell(sell,buy, 2000d);
        System.out.println(f.isHumanHasBeenAnOwner(sell));
        System.out.println(f.isHumanHasBeenAnOwner(buy));
        System.out.println(f.doesHumanHasSoldACarToAnotherHuman(sell,buy));
        System.out.println(f.doesHumanHasSoldACarToAnotherHuman(buy,sell));
        System.out.println(f.calculateNumberOfTransactions());
    }
}
