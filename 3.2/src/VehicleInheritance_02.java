// 3.2 - Task 02

interface Vehicle_02 {
    void start();
    void stop();
    String getInfo();
}

abstract class AbstractVehicle implements Vehicle_02 {
    public final String type;
    public final String fuel;
    public final String color;

    public AbstractVehicle(String type, String fuel, String color) {
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
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\n";
    }
}

class Car_02 extends AbstractVehicle {
    public Car_02(String fuel, String color) {
        super("Car", fuel, color);
    }
}

class Motorcycle_02 extends AbstractVehicle {
    public Motorcycle_02(String fuel, String color) {
        super("Motorcycle", fuel, color);
    }
}

class Bus_02 extends AbstractVehicle {
    private final int passengerCapacity;

    public Bus_02(String fuel, String color, int passengerCapacity) {
        super("Bus", fuel, color);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: " + passengerCapacity + " passengers\n";
    }
}

public class VehicleInheritance_02 {
    public static void main(String[] args) {
        Vehicle_02[] vehicles = {
            new Car_02("Petrol", "Red"),
            new Motorcycle_02("Gasoline", "Black"),
            new Bus_02("Diesel", "Yellow", 40)
        };

        System.out.println("Vehicle Demonstration\n");

        for (Vehicle_02 vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }
    }
}
