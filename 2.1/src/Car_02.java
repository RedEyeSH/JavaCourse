// 2.1 - Task 02

public class Car_02 {
    private double speed;
    private double gasolineLevel;
    private final String typeName;
    private final double tankCapacity;
    private final double topSpeed;

    public Car_02(String typeName, double tankCapacity, double topSpeed) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.topSpeed = topSpeed;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed = Math.min(speed + 10, topSpeed);
            gasolineLevel = Math.max(0, gasolineLevel - 1);
        } else {
            speed = 0;
        }
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        } else {
            speed = 0;
        }
    }

    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = tankCapacity;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }
}

class CarDriver {
    public static void main(String[] args) {
        Car_02 myCar;

        myCar = new Car_02("Toyota Corolla", 100, 200);
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h. Gasoline level: " + myCar.getGasolineLevel());
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h. Gasoline level: " + myCar.getGasolineLevel());
        }
    }
}