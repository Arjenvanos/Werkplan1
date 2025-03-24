package oop;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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


