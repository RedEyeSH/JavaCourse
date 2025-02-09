// 4.2 - Task 01

class Calculator {
    private int sum;

    // Constructor
    public Calculator() {
        this.sum = 0;
    }

    // Method to reset calculator to zero
    public void reset() {
        this.sum = 0;
    }

    // This method adds a positive integer to the current sum. If the number is negative, throw an exception.
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        this.sum += number;
    }

    // Method to retrieve the current sum
    public int getSum() {
        return sum;
    }

    // Display the current state of the calculator
    public void displayStatus() {
        System.out.println("Current sum: " + getSum());
    }
}

public class Main {
    // Main method for testing
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.add(5);
        calc.add(10);
        calc.displayStatus(); // Output: Current sum: 15

        calc.reset();
        calc.displayStatus(); // Output: Current sum: 0

        try {
            calc.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Output: Exception caught: Negative numbers are not allowed.
        }
    }
}
