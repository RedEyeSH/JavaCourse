// 5.2 - Task 02
import java.util.ArrayList;

class ThreadSafeList implements Runnable {
    private final ArrayList<String> list = new ArrayList<>();

    public synchronized void addElement(String element) {
        list.add(element);
        System.out.println(Thread.currentThread().getName() + " added: " + element);
    }

    public synchronized int getListSize() {
        return list.size();
    }

    public synchronized void removeElement(String element) {
        if (list.contains(element)) {
            list.remove(element);
            System.out.println(Thread.currentThread().getName() + " removed: " + element);
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-1")) {
            for (int i = 0; i < 5; i++) {
                addElement("Item " + i);
            }
        } else if (Thread.currentThread().getName().equals("Thread-2")) {
            for (int i = 0; i < 3; i++) {
                removeElement("Item " + i);
            }
        }
    }
}

public class ThreadSafe {
    public static void main(String[] args) {
        ThreadSafeList list = new ThreadSafeList();

        Thread t1 = new Thread(list, "Thread-1");
        Thread t2 = new Thread(list, "Thread-2");

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List size: " + list.getListSize());
    }
}
