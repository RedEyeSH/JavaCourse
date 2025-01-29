// 2.3 - Task 05

public class LibraryManagerWithStatistics_05 {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        book1.setRating(4.7);
        book2.setRating(4.2);
        book3.setRating(3.9);

        book1.addReview("Informative and great for beginners.");
        book1.addReview("Well written, very comprehensive.");

        book2.addReview("Excellent book, highly recommend!");

        book3.addReview("Interesting read, but slow at times.");

        library.getAverageBookRating();
        library.getMostReviewedBook();
    }
}

