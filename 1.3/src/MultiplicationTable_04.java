// 1.3 - Task 04
import java.util.Scanner;

public class MultiplicationTable_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        int tries = 0;

        System.out.println("Welcome to the math generator!");
        while (true) {
            int firstVal = (int)(Math.random() * 10) + 1;
            int secondVal = (int)(Math.random() * 10) + 1;
            int calculation = firstVal * secondVal;

            System.out.print("What is " + firstVal + " * " + secondVal + ": ");
            int user_input = scanner.nextInt();

            if (user_input == calculation) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            tries++;

            if (score == 10) {
                System.out.println("Congratulations! You've mastered the multiplication table!");
                break;
            }

            if (tries == 10) {
                System.out.println("You scored " + score + " out of 10. Let's try again!");
                score = 0;
                tries = 0;
            }
        }
    }
}
