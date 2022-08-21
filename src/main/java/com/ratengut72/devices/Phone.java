package com.ratengut72.devices;

import com.ratengut72.creatures.Human;

public class Phone extends Device {

    public Phone(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Phone turned on");
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone() == null || !seller.getPhone().equals(this))  {
            System.out.println("Seller doesn't have that phone for sell. It's scam.");
            return false;
        }
        if (buyer.getCash() < price) {
            System.out.println("Buyer doesn't have enough money. Aborting.");
            return false;
        }

        buyer.setPhone(this);
        seller.setPhone(null);
        seller.addMoney(price);
        buyer.decreaseMoney(price);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");
        return true;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
