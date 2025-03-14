package oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle1 = new Vehicle("Skoda", "Octavia", "11-BB-89", 1999, "Gas");
        Vehicle vehicle2 = new Vehicle("Audi", "A4", "99-XC-12", 2016, "Electric");
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        Vehicle vehicle3 = new Vehicle("Mazda", "MX5", "123-PP-9", 1995, "Petrol");

        try {
            Garage garage = new Garage();
            Vehicle foundVehicle = garage.findVehicle(vehicles, vehicle3);
            System.out.println("Found vehicle: " + foundVehicle);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}