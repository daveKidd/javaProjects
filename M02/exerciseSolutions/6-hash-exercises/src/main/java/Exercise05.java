import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise05 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Instantiate a new HashMap<String, Vehicle>.
        HashMap<String, Vehicle> newVehicleMap = new HashMap<>();

        // 2. Add two vehicles to the new map.
        Vehicle newCar = new Vehicle();
        newCar.setVin("ABCDEFGH123456789");
        newCar.setMake("Honda");
        newCar.setModel("Odyssey");
        newCar.setYear(2016);
        newCar.setColor("Gray");

        Vehicle newCar2 = new Vehicle();
        newCar2.setVin("ABCDEFGH923456789");
        newCar2.setMake("Hyundai");
        newCar2.setModel("Sonata");
        newCar2.setYear(2011);
        newCar2.setColor("Black");

        newVehicleMap.put(newCar.getVin(),newCar);
        newVehicleMap.put(newCar2.getVin(),newCar2);

        // 3. Add items from the new map to `vehicleMap` using the `putAll` method.
        vehicleMap.putAll(newVehicleMap);

        // 4. Confirm the vehicles were added by retrieving on with its VIN and printing it to the console.
        System.out.println(vehicleMap.get(newCar.getVin()));
        System.out.println(vehicleMap.get(newCar2.getVin()));

    }
}
