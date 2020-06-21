package pl.camp.it.db;

import pl.camp.it.model.Bus;
import pl.camp.it.model.Car;
import pl.camp.it.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    private static final VehicleRepository vehicleRepository = new VehicleRepository();

    private VehicleRepository() {
    Persistance.loadData(vehicles);

        /*Car c1 = new Car(1, "BMW", "M8", "jdkdjd");

        Car c2 = new Car(2, "Toyota", "Supra", "38usgsid");

        Car c3 = new Car(3, "Audi", "R8", "dgdt48hd");

        this.vehicles.add(c1);
        this.vehicles.add(c2);
        this.vehicles.add(c3);

        this.vehicles.add(new Bus(4, "Solaris", "152",
                "123f5", 40, 6));

        this.vehicles.add(new Bus(5, "MAN", "A100",
                "dffe344", 50, 8));*/
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static VehicleRepository getRepository(){
        return vehicleRepository;
    }
}
