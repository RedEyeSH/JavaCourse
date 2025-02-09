## Program Overview

This program is a simple `Calculator` class designed to add positive integers. It allows adding numbers, resetting the sum, and retrieving the current sum. If a negative number is added, an exception will be thrown.

## Code Explanation

The `Calculator` class contains the following methods:

- **Constructor (`Calculator()`):**  
  Initializes the sum to 0 when a new `Calculator` object is created.

- **`reset()`**  
  Resets the current sum back to zero. This is useful if you want to start over.

- **`add(int number)`**  
  Adds a positive integer to the sum. If the number is negative, it throws an exception with the message `"Negative numbers are not allowed."`.

- **`getSum()`**  
  Returns the current sum of the numbers added.

- **`displayStatus()`**  
  Prints out the current sum to the console.

## Example Usage

Here’s how the `Calculator` can be used:

```java
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
