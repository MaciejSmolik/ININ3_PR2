package com.ratengut72.devices;

import com.ratengut72.creatures.Human;
import com.ratengut72.creatures.Sellable;

import java.util.ArrayList;
import java.util.List;

public abstract class Car extends Device implements Sellable {

    private Double weight;
    private List<Human> owners = new ArrayList<>();

    public Car(String producer, String model, int yearOfProduction, Double weight) {
        super(producer,model,yearOfProduction);
        this.weight = weight;
    }

    public Car(String producer, String model, int yearOfProduction, Double weight, Double price) {
        super(producer, model, yearOfProduction, price);
        this.weight = weight;
        this.price = price;
    }

    public List<Human> getOwners() {
        return owners;
    }

    public void setOwners(List<Human> owners) {
        this.owners = owners;
    }

    public abstract void refuel();

    @Override
    public void turnOn() {
        System.out.println("Car turned on");
    }

    public boolean sell(Human seller, Human buyer, Double price) {
        int sellerCarIndex = seller.getIndexOfCar(this);
        if (sellerCarIndex == -1) {
            throw new SellCarException("Seller doesn't have that car for sell. It's scam.");
        }
        if (!this.getOwners().get(getOwners().size() - 1).equals(seller)) {
            throw new SellCarException("Seller is not an owner of this car!");
        }
        if(buyer.isGarageFull()){
            throw new SellCarException("Seller doesn't have space for that car");
        }
        if(buyer.getCash() < price){
            throw new SellCarException("Buyer doesn't have enough money. Aborting");
        }
        buyer.getGarage()[buyer.getFirstEmptyPlaceInGarage()] = this;
        seller.addMoney(price);
        buyer.decreaseMoney(price);
        seller.setCar(null,sellerCarIndex);
        this.owners.add(buyer);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");
        return true;
    }

    public boolean isHumanHasBeenAnOwner(Human human) {
        return owners.stream().anyMatch(h -> h.equals(human));
    }

    public boolean doesHumanHasSoldACarToAnotherHuman(Human seller, Human buyer) {
        if (owners.contains(seller)) {
            if (owners.size() == owners.indexOf(seller) + 2)
                return owners.get(owners.indexOf(seller) + 1).equals(buyer);
        }
        return false;
    }

    public int calculateNumberOfTransactions() {
        if (!owners.isEmpty()) {
            return owners.size()/2;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;

        if (!producer.equals(car.producer)) return false;
        if (!model.equals(car.model)) return false;
        if (!weight.equals(car.weight)) return false;
        return price.equals(car.price);
    }

    @Override
    public int hashCode() {
        int result = producer.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
