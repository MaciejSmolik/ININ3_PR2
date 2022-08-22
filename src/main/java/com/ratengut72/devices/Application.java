package com.ratengut72.devices;

import java.util.Comparator;

public class Application implements Comparable<Application> {

    private final String name;
    private final String version;
    private final Double price;

    public Application(String name, String version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application that)) return false;

        if (!name.equals(that.name)) return false;
        if (!version.equals(that.version)) return false;
        return price.equals(that.price);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + version.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Application o) {
        if (this.getPrice() < o.getPrice())
            return -1;
        else if (this.getPrice() > o.getPrice())
            return 1;
        return 0;
    }
}
