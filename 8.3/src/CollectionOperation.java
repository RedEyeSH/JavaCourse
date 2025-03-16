import java.util.ArrayList;
import java.util.List;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(10, 5, 8, 20, 15, 3, 12));

        numbers.removeIf(num -> num % 2 == 0);
        System.out.println("Odds: " + numbers);

        numbers.replaceAll(num -> num * 2);
        System.out.println("Doubled odds: " + numbers);

        int total = 0;
        for (int n : numbers) {
            total += n;
        }

        System.out.println("Total in sum: " + total);
    }
}
