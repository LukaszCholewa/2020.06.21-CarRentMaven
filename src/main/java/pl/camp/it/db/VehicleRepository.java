package pl.camp.it.db;

import pl.camp.it.model.Bus;
import pl.camp.it.model.Car;
import pl.camp.it.model.Vehicle;

public class VehicleRepository {
    private Vehicle[] vehicles = new Vehicle[10];

    public VehicleRepository() {
        Car c1 = new Car(1, "BMW", "M8", "jdkdjd");

        Car c2 = new Car(2, "Toyota", "Supra", "38usgsid");

        Car c3 = new Car(3, "Audi", "R8", "dgdt48hd");

        this.vehicles[0] = c1;
        this.vehicles[1] = c2;
        this.vehicles[2] = c3;

        this.vehicles[3] = new Bus(4, "Solaris", "152",
                "123f5", 40, 6);

        this.vehicles[4] = new Bus(5, "MAN", "A100",
                "dffe344", 50, 8);
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
