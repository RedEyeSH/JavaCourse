// 2.1 - Task 03

public class CoffeeMaker_03 {
    private boolean isOn;
    private String type;
    private int amount;

    public CoffeeMaker_03() {
        this.isOn = false;
        this.type = "normal";
        this.amount = 10;
    }

    public boolean isOn() {
        return isOn;
    }

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

    public void setCoffeeType(String type) {
        if (isOn()) {
            this.type = type;
        } else {
            System.out.println("Cannot set coffee type. Coffee maker is off.");
        }
    }

    public String getCoffeeType() {
        return type;
    }

    public void setCoffeeAmount(int amount) {
        if (isOn()) {
            if (amount >= 10 && amount <= 80) {
                this.amount = amount;
            } else {
                System.out.println("Invalid amount of coffee. Please select between 10 and 80 ml.");
            }
        } else {
            System.out.println("Cannot set coffee amount. Coffee maker is off.");
        }
    }

    public int getCoffeeAmount(){
        return amount;
    }
}

class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker_03 coffeeMaker = new CoffeeMaker_03();

        coffeeMaker.switchOn();
        System.out.println("Coffee maker is on");

        coffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type is " + coffeeMaker.getCoffeeType());

        coffeeMaker.setCoffeeAmount(50);
        System.out.println("Coffee amount is " + coffeeMaker.getCoffeeAmount() + " ml");

        coffeeMaker.switchOff();
        System.out.println("Coffee maker is off");
    }
}
