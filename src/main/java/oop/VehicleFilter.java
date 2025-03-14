package oop;


import java.util.ArrayList;
import java.util.List;

public class VehicleFilter {

    public boolean testVehicleOkeForService(Vehicle vehicle) {
        if (vehicle.year > 2000) {
            if (checkVehicleIsGerman(vehicle.brand)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkVehicleIsGerman(String brand) {
        List<String> germanVerhicles = new ArrayList<>();
        germanVerhicles.add("Volkswagen");
        germanVerhicles.add("Mercedes");
        germanVerhicles.add("BMW");
        if (germanVerhicles.contains(brand)) {
            return true;
        }
        return false;
    }
}
