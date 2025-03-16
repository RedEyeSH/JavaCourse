import java.util.Arrays;

public class Average {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        double average = Arrays.stream(numbers).average().orElse(0);

        System.out.println("List of numbers: " + Arrays.toString(numbers));
        System.out.println("Average: " + average);
    }
}
