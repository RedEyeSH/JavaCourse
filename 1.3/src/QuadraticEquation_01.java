// 1.3 - Task 01
import java.util.Scanner;

public class QuadraticEquation_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number (a): ");
        int firstNum = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter second number (b): ");
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter third number (c): ");
        int thirdNum = Integer.parseInt(scanner.nextLine());

        double equation = Math.pow(secondNum, 2) - 4 * firstNum * thirdNum;

        if (equation < 0) {
            System.out.println("No real roots");
        } else {
            double root1 = (-secondNum + Math.sqrt(equation)) / (2 * firstNum);
            double root2 = (-secondNum - Math.sqrt(equation)) / (2 * firstNum);

            if (root1 == root2) {
                System.out.println("The root is: " + root1);
            } else {
                System.out.println("The roots are: " + root1 + " and " + root2);
            }
        }
    }

}
