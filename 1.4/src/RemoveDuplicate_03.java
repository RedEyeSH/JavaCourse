// 1.4 - Task 03
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicate_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integers " + (i + 1) + ": " );
            int number = scanner.nextInt();

            if (!list.contains(number)) {
                list.add(number);
            }
        }

        System.out.println();

        System.out.println("The array without duplicated:");
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
