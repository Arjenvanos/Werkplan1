package oop;

import java.util.List;

public class Garage {

    List<Vehicle> vehicles;

    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void remove(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }


    public Vehicle findVehicle(List<Vehicle> vehicles, Vehicle vehicleToFind) throws NotFoundException {
        if (vehicles.contains(vehicleToFind)) {
            return vehicleToFind;
        } else {
            throw new NotFoundException("Vehicle " + vehicleToFind + " not found");
        }

    }
}


