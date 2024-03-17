import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;
import java.util.Map;

public class Exercise03 {

    // 1. Create a method to print all Vehicles in a HashMap<String, Vehicle>.
    // Consider making it `public` so you can use it in other exercises.

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 2. Print `vehicleMap` using your "print all" method.
        printAll(vehicleMap);
    }

    public static void printAll(HashMap<String,Vehicle> carMap){

        for (Vehicle car : carMap.values()) {
            System.out.println(car);
        }

//        for(Map.Entry<String, Vehicle> car : carMap.entrySet()){
//            System.out.println(car.getKey() + ": " + car.getValue());
//        }
    }
}
