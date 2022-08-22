package com.ratengut72.devices;

import com.ratengut72.creatures.Human;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Phone extends Device {

    static final String DEFAULT_APP_VERSION  = "latest";
    static final String DEFAULT_SERVER = "play.store.com";
    static final String DEFAULT_PROTOCOL = "http";

    private Set<Application> applications = new LinkedHashSet<>();
    private Human owner;

    public Phone(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    public Phone(String producer, String model, int yearOfProduction, Human owner) {
        super(producer, model, yearOfProduction);
        this.owner = owner;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    @Override
    public void turnOn() {
        System.out.println("Phone turned on");
    }

    public void installAnApplication(Application application) {
        if (Objects.nonNull(owner)) {
            if (owner.getCash() >= application.getPrice()) {
                if (!applications.contains(application)) {
                    owner.decreaseMoney(application.getPrice());
                    this.getApplications().add(application);
                }
            }

        }
    }

    public boolean doesApplicationHasBeenInstalled(Application application) {
        return applications.contains(application);
    }

    public boolean doesApplicationHasBeenInstalled(String name) {
        return applications.stream().anyMatch(application -> application.getName().equals(name));
    }

    public void displayAllFreeApplications() {
        Set<Application> freeAps = applications.stream()
                .filter(application -> application.getPrice() == 0.0).collect(Collectors.toSet());
        System.out.println("Free aps: " + freeAps);
    }

    public Double calculateTotalApplicationsValue() {
        return applications.stream().map(Application::getPrice).reduce(0.0,Double::sum);
    }

    public void displayApplicationsInAlphabeticOrder() {
        List<String> names = applications.stream().map(Application::getName).sorted().toList();
        System.out.println("Installed applications in alphabetic order: " + names);
    }

    public void displayApplicationsFromCheapestToMostExpensive() {
        List<String> names = applications.stream().sorted(Application::compareTo)
                .map(Application::getName).toList();
        System.out.println("Installed applications in from cheapest to most expensive: " + names);
    }

    public void installAnApp(String name) {
        System.out.println("Installing an app: " + name);
    }

    public void installAnApp(String name, String version) {
        System.out.println("Installing an app: " + name + ",version: " + version);
    }

    public void installAnApp(String name, String version, String server) {
        System.out.println("Installing an app: " + name + ",version: " + version + ", from server: " + server);
    }

    public void installAnApp(List<String> applications) {
        System.out.println("Installing an apps: " + applications.toString());
    }

    public void installAnApp(URL application) {
        System.out.println("Installing an app: " + application);
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
