// 1.3 - Task 03
import java.util.Scanner;

public class PrimeNumber_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start number: ");
        int startNum = scanner.nextInt();

        System.out.print("Enter the end number: ");
        int endNum = scanner.nextInt();

        System.out.println("Prime numbers between " + startNum + " and " + endNum + " are:");

        for (int i = startNum; i <= endNum; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
