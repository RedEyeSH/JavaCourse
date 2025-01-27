// 2.1 - Task 04

public class CruiseControl_04 {
    private double speed;
    private double gasolineLevel;
    private final String typeName;
    private final double tankCapacity;
    private final double topSpeed;

    private double targetSpeed;
    private boolean cruiseControlOn;

    public CruiseControl_04(String typeName, double tankCapacity, double topSpeed) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.topSpeed = topSpeed;

        this.targetSpeed = 0;
        this.cruiseControlOn = false;
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

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public boolean turnOnCruiseControl(double targetSpeed) {
        if (targetSpeed >= 10 && targetSpeed <= topSpeed) {
            this.targetSpeed = targetSpeed;
            cruiseControlOn = true;
            adjustSpeedToTarget();
            return true;
        } else {
            System.out.println("Cruise control cannot be turned on. Target speed is not valid.");
            return false;
        }
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
        System.out.println("Cruise control is off.");
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void adjustSpeedToTarget() {
        if (cruiseControlOn) {
            System.out.println("Cruise control is on. Target speed: " + targetSpeed + " km/h.");
            while (speed < targetSpeed && gasolineLevel > 0) {
                accelerate();
                System.out.println("Accelerating to reach target speed: " + speed + " km/h.");
            }

            while (speed > targetSpeed && gasolineLevel > 0) {
                decelerate(10);
                System.out.println("Decelerating to reach target speed: " + speed + " km/h");
            }
        }
    }
}

class CarDriver_04 {
    public static void main(String[] args) {
        CruiseControl_04 myCar = new CruiseControl_04("Toyota Corolla", 100, 180);

        myCar.fillTank();

        if (myCar.turnOnCruiseControl(100)) {
            System.out.println();
            System.out.println("Target speed of " + myCar.getTargetSpeed() + " km/h reached.\n");

            myCar.turnOffCruiseControl();
            System.out.println("Current speed after cruise control off: " + myCar.getSpeed() + " km/h");
        }
    }
}
