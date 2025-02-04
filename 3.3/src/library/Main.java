// 3.3 - Task 2 and 3
package library;
import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

public class Main {
    public static void main(String[] args) {
        // Create instances of Library, Book, LibraryMember
        // Add books and members to the library
        // Perform borrowing and returning operations
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", "123456789");
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", "987654321");
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", "112233445");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        LibraryMember member1 = new LibraryMember("Alice", 101);
        LibraryMember member2 = new LibraryMember("Bob", 102);

        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);

        library.returnBook(member1, book1);
        library.returnBook(member2, book2);

        // Task 3
        library.reserveBook(member1, book1);
        library.reserveBook(member2, book2);

        library.displayReservedBooks(member1);
        library.displayReservedBooks(member2);

        library.reserveBook(member2, book1);
        library.cancelReservation(member1, book1);

        library.displayReservedBooks(member1);
        library.displayReservedBooks(member2);
    }
}
