// 2.3 - Library class
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("\nBook " + '"' + book.getTitle() + '"' + " added successfully.");
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

    public void borrowBook(String title) {
        boolean isFound = false;

        System.out.println("\nAttempting to borrow the book: " + '"' + title + '"');
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Borrowed " + '"' + book.getTitle() + '"' + " successfully.");
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Sorry, the book " + '"' + title + '"' + " is not available in the library.");
        }
    }

    public void returnBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            System.out.println("\nReturned " + '"' + book.getTitle() + '"' + " successfully");
        } else {
            System.out.println("\nBook returned failed.");
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
