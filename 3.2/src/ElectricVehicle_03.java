// 3.2 - Task 03

interface ElectricVehicle {
    void charge();
}

interface Vehicle_03 {
    void start();
    void stop();
    String getInfo();
}

abstract class AbstractVehicle_03 implements Vehicle_03, ElectricVehicle {
    public final String type;
    public final String fuel;
    public final String color;

    public AbstractVehicle_03(String type, String fuel, String color) {
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
}

class Car_03 extends AbstractVehicle_03 {

    public Car_03(String fuel, String color) {
        super("Car", fuel, color);
    }
}

class Motorcycle_03 extends AbstractVehicle_03 {
    public Motorcycle_03(String fuel, String color) {
        super("Motorcycle", fuel, color);
    }
}

class Bus_03 extends AbstractVehicle_03 {
    private final int passengerCapacity;

    public Bus_03(String fuel, String color, int passengerCapacity) {
        super("Bus", fuel, color);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: " + passengerCapacity + " passengers";
    }
}

class ElectricCar extends AbstractVehicle_03 {
    public int batteryLevel;

    public ElectricCar(String color, int batteryLevel) {
        super("Electric Car", "Electric", color);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge() {
        System.out.println("Charging...");
        batteryLevel = 100;
        System.out.println(type + " is now fully charged!\n");
    }
}

class ElectricMotorcycle extends AbstractVehicle_03 {
    public int batteryLevel;

    public ElectricMotorcycle(String color, int batteryLevel) {
        super("Electric motorcycle", "Electric", color);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge() {
        System.out.println("Charging...");
        batteryLevel = 100;
        System.out.println(type + " is now fully charged!\n");
    }
}

public class ElectricVehicle_03 {
    public static void main(String[] args) {
        Vehicle_03[] vehicles = {
                new Car_03("Petrol", "Red"),
                new Motorcycle_03("Gasoline", "Black"),
                new Bus_03("Diesel", "Yellow", 40),
                new ElectricCar("Blue", 80),
                new ElectricMotorcycle("Green", 60)
        };

        System.out.println("Vehicle Demonstration\n");

        for (Vehicle_03 vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());

            ((ElectricVehicle) vehicle).charge();
        }
    }
}
