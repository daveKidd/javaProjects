import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise08 {

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 1. Instantiate a new HashMap<String, Vehicle> named `twoThousandSix`.
        HashMap<String, Vehicle> twoThousandSix = new HashMap<>();

        // 2. Loop through `vehicleMap` and all 2006 vehicles to `twoThousandSix`;
        for (Vehicle car : vehicleMap.values()) {
            if(car.getYear() == 2006){
                twoThousandSix.put(car.getVin(),car);
            }
        }

        // 3. Loop through `twoThousandSix` and display all vehicles.
        // (You may want to use your print all method from Exercise03.)
        Exercise03.printAll(twoThousandSix);

        // 4. How many 2006 vehicles are there? (Expected: 50)
        System.out.println(twoThousandSix.size());
    }
}
