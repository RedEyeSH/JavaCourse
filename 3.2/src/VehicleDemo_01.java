// 3.2 - Task 01

interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

class Car implements Vehicle {
    private final String type = "Car";
    private final String fuel;
    private final String color;

    public Car(String fuel, String color) {
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\n";
    }
}

class Motorcycle implements Vehicle {
    private final String type = "Motorcycle";
    private final String fuel;
    private final String color;

    public Motorcycle(String fuel, String color) {
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\n";
    }
}

class Bus implements Vehicle {
    private final String type = "Bus";
    private final String fuel;
    private final String color;
    private final int passengerCapacity;

    public Bus(String fuel, String color, int passengerCapacity) {
        this.fuel = fuel;
        this.color = color;
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: " + passengerCapacity + " passengers\n";
    }
}

public class VehicleDemo_01 {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Petrol", "Red"),
            new Motorcycle("Gasoline", "Black"),
            new Bus("Diesel", "Yellow", 40)
        };

        System.out.println("Vehicle Demonstration\n");

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo());
        }
    }
}
