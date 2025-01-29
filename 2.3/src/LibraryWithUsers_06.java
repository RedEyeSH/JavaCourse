// 2.3 - Task 06
import java.util.ArrayList;

public class LibraryWithUsers_06 {
    public static void main(String[] args) {
        Library_06 library = new Library_06();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("Quang", 20);
        User user2 = new User("Shane", 19);
        User user3 = new User("Erik", 20);

        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);

        library.displayBooks();

        library.borrowBook("Introduction to Java Programming", "Quang");
        library.borrowBook("Data Structures and Algorithms", "Quang");
        library.returnBook(book1, "Quang");

        library.displayUsers();
    }
}

// Creating a new Library_06 class to prevent errors from previous tasks
class Library_06 {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("\nBook " + '"' + book.getTitle() + '"' + " added successfully.");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("\nUser " + '"' + user.getName() + '"' + " created successfully.");
    }

    public void displayBooks() {
        int count = 0;

        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("\nLibrary Catalog:");
            for (Book item : books) {
                count++;
                System.out.println(count + ". Title: " + '"' + item.getTitle() + '"' + ", Author: " + '"' + item.getAuthor() + '"' + ", Year: " + item.getPublicationYear());
            }
        }
    }

    public void findBooksByAuthor(String author) {
        boolean isFound = false;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("\nBooks by Author " + '"' + author + '"' + ":");
                System.out.println("Title: " + '"' + book.getTitle() + '"' + ", Year: " + book.getPublicationYear());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("\nBooks by Author " + '"' + author + '"' + ": Not Found!");
        }

    }

    public void borrowBook(String title, String username) {
        User borrower = findUsername(username);
        Book book = findBook(title);

        if (borrower == null) {
            System.out.println("User not found: " + username);
            return;
        } else if (book == null) {
            System.out.println("Book not found: " + title);
            return;
        }

        borrower.borrowBook(book);

        System.out.println("\nAttempting to borrow the book: " + '"' + title + '"');
        for (Book bookType : books) {
            if (bookType.getTitle().equalsIgnoreCase(title)) {
                books.remove(bookType);
                System.out.println('"' + borrower.getName() + '"' + " Borrowed " + '"' + bookType.getTitle() + '"' + " successfully.");
                break;
            }
        }
    }

    public void returnBook(Book book, String username) {
        User user = findUsername(username);

        if (user == null) {
            System.out.println("\nUser not found: " + username);
            return;
        }

        if (!books.contains(book)) {
            books.add(book);
            for (Book books : user.getBorrowedBooks()) {
                if (user.getBorrowedBooks().contains(book)) {
                    user.getBorrowedBooks().remove(books);
                }
            }
            System.out.println("\n" + '"' + username + '"' + " returned " + '"' + book.getTitle() + '"' + " successfully");
        } else {
            System.out.println("\nBook returned failed.");
        }
    }

    public User findUsername(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public Book findBook(String name) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            return;
        }

        int count = 0;

        for (User user : users) {
            System.out.println("\nUser: " + user.getName() + ", Age: " + user.getAge());
            if (user.getBorrowedBooks().isEmpty()) {
                System.out.println("Borrowed books: none");
            } else {
                System.out.println("Borrowed books: ");
                for (Book book : user.getBorrowedBooks()) {
                    count++;
                    System.out.println(count + ". " + book.getTitle());
                }
            }
        }
    }

    public boolean checkBook(String title) { // changed from isBookAvailable to checkBook
        boolean isFound = false;

        System.out.println("\nChecking availability for the book: " + '"' + title + '"');
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public void isBookAvailable(String title) { // own print method
        boolean isFound = false;

        if (checkBook(title)) {
            isFound = true;
        }
        System.out.println("Is " + '"' + title + '"' + " available? " + isFound);
    }

    public double calculateAverageBookRating() { // changed from getAverageBookRating to calculateAverageBookRating
        if (books.isEmpty()) {
            return 0;
        }

        double count = 0;
        for (Book book : books) {
            count += book.getRating();
        }
        return count / books.size();
    }

    public void getAverageBookRating() { // own print method
        if (!books.isEmpty()) {
            System.out.printf("\nAverage Books rating: %.1f\n", calculateAverageBookRating());
        } else {
            System.out.println("\nNo books in the library to calculate an average rating.");
        }
    }

    public Book calculateMostReviewedBook() { // changed from getMostReviewedBook to calculateMostReviewedBook
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return null;
        }

        Book mostReviewedBook = books.get(0);
        int maxReviews = mostReviewedBook.getReviews().size();

        for (Book book : books) {
            int reviewCount = book.getReviews().size();
            if (reviewCount > maxReviews) {
                mostReviewedBook = book;
                maxReviews = reviewCount;
            }
        }
        return mostReviewedBook;
    }

    public void getMostReviewedBook() { // own print method
        if (!books.isEmpty()) {
            System.out.println("\nMost reviewed book: " + '"' + calculateMostReviewedBook().getTitle() + '"' + "with " + calculateMostReviewedBook().getReviews().size() + " reviews");
        } else {
            System.out.println("\nNo books in the library to calculate the most reviewed book.");
        }
    }
}
