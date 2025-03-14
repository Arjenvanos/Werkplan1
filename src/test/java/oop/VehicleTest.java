package oop;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@QuarkusTest
public class VehicleTest {


    @Test
    public void testVehicleFilter() {
        // when
        VehicleFilter vehicleFilter = new VehicleFilter();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Volkswagen");
        vehicle1.setYear(1999);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("BMW");
        vehicle2.setYear(2001);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setBrand("Skoda");
        vehicle3.setYear(2001);

        // then
        assertFalse(vehicleFilter.testVehicleOkeForService(vehicle1));
        assertTrue(vehicleFilter.testVehicleOkeForService(vehicle2));
        assertFalse(vehicleFilter.testVehicleOkeForService(vehicle3));
    }

    @Test
    public void filterByFuelType() {
        // given
        Vehicle vehicle3 = new Vehicle();
        vehicle3.setBrand("Volkswagen");
        vehicle3.setFuelType("Diesel");

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setBrand("BMW");
        vehicle4.setFuelType("Electric");

        List<Vehicle> vehicles = List.of(vehicle3, vehicle4);

        // when
        List<Vehicle> electricVehicles = vehicles.stream().filter(vehicle -> vehicle.getFuelType().equals("Electric")).toList();

        // then
        electricVehicles.forEach(vehicle -> System.out.println(vehicle.brand));
    }

    @Test
    public void testFindVehicle() throws NotFoundException {
        // given
        Vehicle vehicle5 = new Vehicle();
        vehicle5.setBrand("Volkswagen");
        vehicle5.setFuelType("Diesel");

        Vehicle vehicle6 = new Vehicle();
        vehicle6.setBrand("BMW");
        vehicle6.setFuelType("Electric");

        List<Vehicle> vehicles = List.of(vehicle5, vehicle6);

        // when
        Garage garage = new Garage();
        var result = garage.findVehicle(vehicles, vehicle6);

        // then
        assertEquals(vehicle6, result);
        assertEquals(vehicle6.brand, result.brand);
    }

    @Test
    public void testReadyForService() {
        // given
        Vehicle vehicle7 = new Vehicle();
        vehicle7.setBrand("Volkswagen");
        vehicle7.setFuelType("Diesel");
        vehicle7.setYear(2001);

        Vehicle vehicle8 = new Vehicle();
        vehicle8.setBrand("BMW");
        vehicle8.setFuelType("Electric");
        vehicle8.setYear(1975);

        List<Vehicle> vehicles = List.of(vehicle7, vehicle8);

        // when
        FleetManagement fleetManagement = new FleetManagement();
        var result = fleetManagement.readyForService2(vehicles);

        // then
        assertEquals(1, result.size());
        assertEquals(result.getFirst(), vehicle7);
        assertFalse(result.contains(vehicle8));
    }
}
