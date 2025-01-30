// 3.1 - Task 01

public class SportsCar_01 extends Car {
    public SportsCar_01(String typeName, double tankCapacity, double topSpeed) {
        super(typeName, tankCapacity, topSpeed);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed = Math.min(speed + 20, topSpeed);
            gasolineLevel = Math.max(0, gasolineLevel - 5);
        } else {
            speed = 0;
        }
    }

    @Override
    public void decelerate(int amount) {
        if (amount > 0) {
            speed = Math.max(0, speed - (amount + 5));
        }
    }

    public static void main(String[] args) {
        SportsCar_01 car1 = new SportsCar_01("Ferrari", 1000, 450);

        System.out.println("Car type " + '"' + car1.getTypeName() + '"' + " created successfully.");

        car1.fillTank();

        for (int i = 0; i < 10; i++) {
            car1.accelerate();

            System.out.println("Car current speed: " + car1.getSpeed() + " km/h. Gasoline level: " + car1.getGasolineLevel() );
        }

        System.out.println("Car is decelerating...");

        while (car1.getGasolineLevel() > 0 && car1.getSpeed() != 0) {
            car1.decelerate(20);
            System.out.println("Car current speed: " + car1.getSpeed() + " km/h. Gasoline level: " + car1.getGasolineLevel());
        }
    }
}