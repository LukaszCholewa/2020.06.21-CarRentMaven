package pl.camp.it.model;

public class Bus extends Vehicle {
    private int personsAmount;
    private int wheelsCount;

    public Bus(int id, String brand, String model, String vin, int personsAmount, int wheelsCount) {
        super(id, brand, model, vin);
        this.personsAmount = personsAmount;
        this.wheelsCount = wheelsCount;
    }

    public int getPersonsAmount() { return this.personsAmount; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Bus:{\n")
                .append("id = ")
                .append(this.getId())
                .append("\n")
                .append("brand = ")
                .append(this.getBrand())
                .append("\n")
                .append("model = ")
                .append(this.getModel())
                .append("\n")
                .append("vin = ")
                .append(this.getVin())
                .append("\n")
                .append("personsAmound = ")
                .append(this.personsAmount)
                .append("\n")
                .append("wheelsCount = ")
                .append(this.wheelsCount)
                .append("}")
                .toString();
    }

    public int getWheelsCount() { return this.wheelsCount; }

}
