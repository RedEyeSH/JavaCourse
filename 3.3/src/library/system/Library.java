package library.system;

import library.model.Book;
import library.model.LibraryMember;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;
    private final ArrayList<LibraryMember> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        // Add book to the library
        books.add(book);
        System.out.println("Book " + '"' + book.getTitle() + '"' + " added successfully.\n");
    }

    public void addMember(LibraryMember member) {
        // Add member to the library
        members.add(member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        // Borrow book from the library
        if (books.contains(book)) {
            books.remove(book);
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + '"' + book.getTitle() + '"' + "\n");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        // Return book to the library
        if(member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            books.remove(book);
            System.out.println(member.getName() + " returned " + '"' + book.getTitle() + '"' + "\n");
        }
    }

    // Task 3
    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully.\n");
        } else {
            System.out.println("Book is already reserved.\n");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled successfully.\n");
        } else {
            System.out.println("Book was not reserved by this member.\n");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }
}