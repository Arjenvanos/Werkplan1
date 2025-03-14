package oop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {

    String brand;
    String model;
    String licensPlate;
    int year;
    String fuelType;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, String licensPlate, int year, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.licensPlate = licensPlate;
        this.year = year;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensPlate='" + licensPlate + '\'' +
                ", year=" + year +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
