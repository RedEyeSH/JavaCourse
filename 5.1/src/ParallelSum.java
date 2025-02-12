// 5.1 - Task 02
import java.util.ArrayList;

class SumCalculator extends Thread {
    private final int[] numbers;
    private final int start;
    private final int end;
    private long totalSum;

    public SumCalculator(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public void run() {
        totalSum = 0;
        for (int i = start; i < end; i++) {
            totalSum += numbers[i];
        }
    }

    public long getTotalSum() {
        return totalSum;
    }
}

public class ParallelSum {
    private final static int size = 2100;

    public static void execute(int cores) {
        ArrayList<SumCalculator> sumList = new ArrayList<>();

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }

        int chunkSize = size / cores;

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = size;

            if (i < cores - 1) {
                end = (i + 1) * chunkSize;
            }

            sumList.add(new SumCalculator(numbers, start, end));
        }

        long startTime = System.nanoTime();
        for (SumCalculator sm : sumList) {
            sm.start();
        }

        long result = 0;
        for (SumCalculator sm : sumList) {
            try {
                sm.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result += sm.getTotalSum();
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - startTime;
        System.out.println("Time elapsed " + timeElapsed / 10e6 + " ms. The result is " + result);
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Our system has " + cores + " processor cores.\n");
        System.out.print("1 Thread(s): "); execute(1);
        System.out.print("1 Thread(s): "); execute(1);
        System.out.print(cores + " Thread(s): "); execute(cores);
    }
}
