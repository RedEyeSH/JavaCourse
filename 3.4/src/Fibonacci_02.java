import java.io.*;

public class Fibonacci_02 {
    private static final String FILE = "fibonacci.csv";

    public static void main(String[] args) {
        long[] fibonacci = new long[60];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < 61; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write("Index,Fibonacci Number\n");

            for (int i = 0; i < 61; i++) {
                writer.write(i + "," + fibonacci[i] + "\n");
            }

            System.out.println("Fibonacci sequence written to " + FILE);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
