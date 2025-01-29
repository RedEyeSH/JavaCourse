// 2.3 - Task 04

public class LibraryManagerWithFeedback_04 {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        book2.setRating(4.5);

        book1.addReview("Informative and great for beginners.");
        book2.addReview("Excellent book, highly recommend!");
    }
}

