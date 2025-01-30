// 3.1 - Car class

public class Car {
    public double speed;
    public double gasolineLevel;
    public final String typeName;
    public final double tankCapacity;
    public final double topSpeed;

    public Car(String typeName, double tankCapacity, double topSpeed) {
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

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = tankCapacity;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }
}