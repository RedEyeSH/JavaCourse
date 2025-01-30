// 3.1 - Task 02

class Bus extends Car {
    private int passengerCount;
    private final int maxPassengers;
    private boolean isBusDoorOpen;

    public Bus(String typeName, double tankCapacity, double topSpeed) {
        super(typeName, tankCapacity, topSpeed);
        passengerCount = 0;
        maxPassengers = 30;
        isBusDoorOpen = false;
    }

    public void passengerEnter() {
        if (getSpeed() == 0 && isBusDoorOpen()) {
            if (passengerCount < maxPassengers) {
                passengerCount++;
                System.out.println("\nPassenger added to the bus. Current number of passengers: " + passengerCount);
            } else {
                System.out.println("\nBus is at full capacity. Cannot add more passengers.");
            }
        } else {
            System.out.println("\nPassenger cannot be added.");
            System.out.println("Bus current speed: " + getSpeed() + " km/h.");
            System.out.println("Bus door is open? " + isBusDoorOpen());
        }
    }

    public void passengerExit() {
        if (getSpeed() == 0 && passengerCount > 0 && isBusDoorOpen) {
            passengerCount--;
            System.out.println("\nPassenger exited the bus. Passengers remaining: " + passengerCount);
        } else {
            System.out.println("\nCannot remove passenger. The bus must be stopped and have passengers.");
        }
    }

    public void openDoor() {
        if (getSpeed() <= 0) {
            isBusDoorOpen = true;
            System.out.println("\nOpening the bus door...");
        } else if (isBusDoorOpen) {
            System.out.println("\nThe bus door is already open.");
        } else {
            System.out.println("\nPlease stop the bus before opening the door.");
        }
    }

    public void closeDoor() {
        isBusDoorOpen = false;
        System.out.println("\nClosing the bus door...");
    }

    public boolean isBusDoorOpen() {
        return isBusDoorOpen;
    }

    @Override
    public void fillTank() {
        super.fillTank();
        System.out.println("\nBus's tank is filled. Current gasoline level: " + getGasolineLevel());
    }

    @Override
    public void accelerate() {
        if (isBusDoorOpen) {
            System.out.println("\nCannot accelerate. The bus door is open. Please close the door first.");
        } else {
            super.accelerate();
            System.out.println("\nBus is accelerating. Current speed: " + getSpeed() + " km/h");
        }
    }

    @Override
    public void decelerate(int amount) {
        super.decelerate(amount);
        System.out.println("\nBus is decelerating. Current speed: " + getSpeed() + " km/h.");
    }

    public void displayStatus() {
        System.out.println("\nCurrent status of the bus:");
        System.out.println("Passengers: " + passengerCount);
        System.out.println("Is bus door open: " + isBusDoorOpen);
        System.out.println("Current speed: " + getSpeed() + " km/h");
        System.out.println("Gasoline level: " + getGasolineLevel());
    }
}

public class BusWithPassengers_02 {
    public static void main(String[] args) {
        Bus bus1 = new Bus("Bus", 1000, 240);

        bus1.fillTank();

        // First passenger entering
        bus1.openDoor();
        bus1.passengerEnter();
        bus1.closeDoor();

        // Testing for preventing passenger to enter while bus is accelerating
        bus1.accelerate();
        bus1.passengerEnter();
        bus1.decelerate(10);

        // Passenger entering and leaving
        bus1.openDoor();
        bus1.passengerEnter();
        bus1.passengerExit();

        // Testing for if bus door's open then cannot accelerate
        bus1.accelerate();
        bus1.closeDoor();
        bus1.accelerate();

        // Bus status
        bus1.displayStatus();
    }
}
