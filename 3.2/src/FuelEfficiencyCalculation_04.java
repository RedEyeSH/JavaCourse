// 3.2 - Task 04

interface Vehicle_04 {
    void start();
    void stop();
    String getInfo();
    double calculateFuelEfficiency();
}

abstract class AbstractVehicle_04 implements Vehicle_04, ElectricVehicle {
    public final String type;
    public final String fuel;
    public final String color;

    public AbstractVehicle_04(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    public void start() {
        System.out.println(type + " is starting...");
    }

    public void stop() {
        System.out.println(type + " is stopping...");
    }

    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }

    public void charge() {
        System.out.println(type + ": No possible to charge.\n");
    }

    public double calculateFuelEfficiency() {
        return 0.0;
    }
}

class Car_04 extends AbstractVehicle_04 {
    public Car_04(String fuel, String color) {
        super("Car", fuel, color);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 25.0;
    }
}

class Motorcycle_04 extends AbstractVehicle_04 {
    public Motorcycle_04(String fuel, String color) {
        super("Motorcycle", fuel, color);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 50.0;
    }
}

class Bus_04 extends AbstractVehicle_04 {
    private final int passengerCapacity;

    public Bus_04(String fuel, String color, int passengerCapacity) {
        super("Bus", fuel, color);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: " + passengerCapacity + " passengers";
    }

    @Override
    public double calculateFuelEfficiency() {
        return 6.0;
    }
}

class ElectricCar_04 extends AbstractVehicle_04 {
    public int batteryLevel;

    public ElectricCar_04(String color, int batteryLevel) {
        super("Electric Car", "Electric", color);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge() {
        System.out.println("Charging...");
        batteryLevel = 100;
        System.out.println(type + " is now fully charged!\n");
    }

    @Override
    public double calculateFuelEfficiency() {
        return 0.2;
    }
}

class ElectricMotorcycle_04 extends AbstractVehicle_04 {
    public int batteryLevel;

    public ElectricMotorcycle_04(String color, int batteryLevel) {
        super("Electric motorcycle", "Electric", color);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge() {
        System.out.println("Charging...");
        batteryLevel = 100;
        System.out.println(type + " is now fully charged!\n");
    }

    @Override
    public double calculateFuelEfficiency() {
        return 0.15;
    }
}

public class FuelEfficiencyCalculation_04 {
    public static void main(String[] args) {
        Vehicle_04[] vehicles = {
                new Car_04("Petrol", "Red"),
                new Motorcycle_04("Gasoline", "Black"),
                new Bus_04("Diesel", "Yellow", 40),
                new ElectricCar_04("Blue", 80),
                new ElectricMotorcycle_04("Green", 60)
        };

        System.out.println("Vehicle Demonstration\n");

        for (Vehicle_04 vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());

            System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency() + (vehicle instanceof ElectricCar_04 || vehicle instanceof ElectricMotorcycle_04 ? " kWh per kilometer" : " miles per gallon") + "\n");
        }
    }
}
