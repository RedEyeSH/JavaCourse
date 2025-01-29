// 2.3 - Task 01

public class LibraryManager_01 {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("Library Catalog:");
        library.displayBooks();

        library.findBooksByAuthor("John Smith");
    }
}
