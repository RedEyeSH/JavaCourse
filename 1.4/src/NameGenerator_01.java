// 1.4 - Task 01
import java.util.Scanner;

public class NameGenerator_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many times do you want to generate: ");
        int times = scanner.nextInt();

        String[] firstNames = { "Quang", "Erik", "Shane", "Satvik" };
        String[] lastNames = { "Than", "Roigas", "Steelman", "Velpula" };

        for (int i = 0; i < times; i++) {
            int randomFname = (int)(Math.random() * firstNames.length);
            int randomLname = (int)(Math.random() * lastNames.length);
            System.out.println(firstNames[randomFname] + " " + lastNames[randomLname]);
        }
    }
}
