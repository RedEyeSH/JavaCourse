// 5.1 - Task 01

class OddThread extends Thread {
    private final OddEvenPrinter printer;

    public OddThread(OddEvenPrinter printer) {
        this.printer = printer;
    }

    public void run() {
        printer.printOdd();
    }
}

class EvenThread extends Thread {
    private final OddEvenPrinter printer;

    public EvenThread(OddEvenPrinter printer) {
        this.printer = printer;
    }

    public void run() {
        printer.printEven();
    }
}

public class OddEvenPrinter {
    private int currentNumber = 1;
    private final int limit;

    public OddEvenPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (currentNumber <= limit) {
            if (currentNumber % 2 != 0) {
                System.out.println("Odd Thread: " + currentNumber);
                currentNumber++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Printing complete!");
    }

    public synchronized void printEven() {
        while (currentNumber <= limit) {
            if (currentNumber % 2 == 0) {
                System.out.println("Even Thread: " + currentNumber);
                currentNumber++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(20);

        OddThread odd = new OddThread(printer);
        EvenThread even = new EvenThread(printer);

        odd.start();
        even.start();

    }
}

