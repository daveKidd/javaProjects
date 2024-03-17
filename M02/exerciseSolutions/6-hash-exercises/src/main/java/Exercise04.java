import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise04 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Create a new Vehicle. Use a VIN that's easy to remember.
        Vehicle newCar = new Vehicle();
        newCar.setVin("ABCDEFGH123456789");
        newCar.setMake("Honda");
        newCar.setModel("Odyssey");
        newCar.setYear(2016);
        newCar.setColor("Gray");

        // 2. Add the Vehicle to `vehicleMap` with the `put` method.
        vehicleMap.put(newCar.getVin(),newCar);

        // 3. Confirm the Vehicle was added by retrieving it with `get` and printing it to the console.
        System.out.println(vehicleMap.get("ABCDEFGH123456789"));
    }
}
