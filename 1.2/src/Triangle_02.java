// 1.2 - Task 02
import java.util.Scanner;

public class Triangle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the first leg: ");
        double length1 = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter the length of the second leg: ");
        double length2 = Double.parseDouble(scanner.nextLine());

        double hypotenuse = Math.sqrt(Math.pow(length1, 2) + Math.pow(length2, 2));

        System.out.println("The length of the hypotenuse is: " + hypotenuse);
    }
}
