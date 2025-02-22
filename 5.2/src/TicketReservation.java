// 5.2 - Task 01
import java.util.Random;

class Theater {
    private int availableSeats;

    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public synchronized void reserveSeats(int customerId, int requestedSeats) {
        if (availableSeats >= requestedSeats) {
            availableSeats -= requestedSeats;
            System.out.println("Customer " + customerId + " reserved " + requestedSeats + " tickets.");
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + requestedSeats + " tickets.");
        }
    }
}

class Customer extends Thread {
    private static int idCount = 1;
    private final int id;

    private final Theater theater;
    private final int requestedSeats;

    public Customer(Theater theater, int requestedSeats) {
        this.id = idCount++;
        this.theater = theater;
        this.requestedSeats = requestedSeats;
    }

    public int getCustomerId() {
        return id;
    }

    @Override
    public void run() {
        theater.reserveSeats(getCustomerId(), requestedSeats);
    }
}

public class TicketReservation {
    public static void main(String[] args) {
        int totalSeats = 10;
        Theater theater = new Theater(totalSeats);

        Random random = new Random();

        int totalCustomers = 15;
        Thread[] customers = new Thread[totalCustomers];

        for (int i = 0; i < totalCustomers; i++) {
            int requestedSeats = random.nextInt(4) + 1;
            customers[i] = new Customer(theater, requestedSeats);
        }

        for (Thread customer : customers) {
            customer.start();
        }

        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}