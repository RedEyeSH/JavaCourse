// 1.2 - Task 01
import java.util.Scanner;

public class Temperature_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Fahrenheit: ");
        double fahrenheit = Double.parseDouble(scanner.nextLine());

        double celsius = (fahrenheit - 32) / 1.8;

        System.out.printf("Fahrenheit (" + fahrenheit + ") in Celsius is: " + "%.1f", celsius);
    }
}
