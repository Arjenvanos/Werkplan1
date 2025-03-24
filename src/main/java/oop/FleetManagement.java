package oop;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FleetManagement {

    List<Garage> garages;
    String smallService;
    String bigService;

    /*public List<Vehicle> readyForService(List<Vehicle> vehiclesToTest) {
        VehicleFilter vehicleFilter = new VehicleFilter();
        List<Vehicle> vehiclesReadyForService = new ArrayList<>();
        try {
            vehiclesReadyForService = vehiclesToTest.stream()
                    .filter(vehicleFilter::testVehicleOkeForService)
                    .toList();
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return vehiclesReadyForService;
    }*/

    public List<Vehicle> readyForService2(List<Vehicle> vehiclesToTest) {
        VehicleFilter vehicleFilter = new VehicleFilter();
        List<Vehicle> vehiclesReadyForService = new ArrayList<>();
        try {
            vehiclesReadyForService = vehiclesToTest.stream()
                    .filter(vehicle -> {
                        try {
                            return vehicleFilter.testVehicleOkeForService(vehicle);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return false;
                        }

                    })
                    .toList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vehiclesReadyForService;
    }
}
