// 1.1 - Task 03
import java.util.Scanner;

public class Sum_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give the first number: ");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.print("Give the second number: ");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.print("Give the third number: ");
        int third = Integer.parseInt(scanner.nextLine());

        int sum = first + second + third; // Lasketaan kaikkien numeroiden summa
        int product = first * second * third; // Lasketaan kaikkien numeroiden tulo
        double average = sum / 3.0; // Lasketaan keskiarvo jakamalla numeroiden summa kolmen luvulla

        // Tulostetaan summa, tulo ja keskiarvo
        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);
    }
}