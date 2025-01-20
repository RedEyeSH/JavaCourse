// 1.3 - Task 02
import java.util.Scanner;

public class BinaryValues_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binaryNum = scanner.next();

        int result = 0;
        int binaryLength = binaryNum.length() - 1;

        String regex = "[0-1]+";

        if (binaryNum.matches(regex)) {
            for (int i = 0; i < binaryNum.length(); i++) {
                char digitChar = binaryNum.charAt(i);
                int digit = Character.getNumericValue(digitChar);

                result += digit * (int)Math.pow(2, binaryLength);
                binaryLength--;
            }
            System.out.println("The decimal equivalent: " + result);
        } else {
            System.out.println("Invalid binary value.");
        }
    }
}
