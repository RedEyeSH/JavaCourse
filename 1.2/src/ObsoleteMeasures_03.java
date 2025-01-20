// 1.2 - Task 03
import java.util.Scanner;

public class ObsoleteMeasures_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): ");
        int weight = Integer.parseInt(scanner.nextLine());

        double luoti = weight / 13.28;

        double luotiRemainder = luoti % 32;
        double luotiResult = luoti - luotiRemainder;

        double naulaResult = luotiResult / 32;
        int naulaRemainder = (int)naulaResult % 20;

        double lieviskaResult = naulaResult - naulaRemainder;
        int lieviskaRemainder = (int)lieviskaResult / 20;

        System.out.printf(weight + " grams is " + lieviskaRemainder + " lieviskä, " + naulaRemainder + " naula, and %.2f %s", luotiRemainder, "luoti.");
    }
}
