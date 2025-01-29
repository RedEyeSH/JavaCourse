// 2.3 - Task 06
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
