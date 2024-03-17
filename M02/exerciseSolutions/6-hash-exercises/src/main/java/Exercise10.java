import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise10 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Replace the vehicle with VIN 2G4WD582061270646 with a new Orange 1994 Chrysler School Bus.
        Vehicle newCar = new Vehicle();
        newCar.setVin("ABCDEFGH123456789");
        newCar.setMake("Chrysler");
        newCar.setModel("School Bus");
        newCar.setYear(1994);
        newCar.setColor("Orange");

        vehicleMap.replace("2G4WD582061270646",newCar);

        // 2. Retrieve the new vehicle from `vehicleMap` and print it to confirm it was updated.
        System.out.println(vehicleMap.get("2G4WD582061270646"));
    }
}
