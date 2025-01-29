import java.util.ArrayList;

public class Book {
    private final String title;
    private final String author;
    private final int publicationYear;

    // Task 4 afterwards
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setRating(double rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
            System.out.println("\nRating for: " + '"' + title + '"' + " set to: " + rating);
        } else {
            System.out.println("Rating should be 1-5");
        }
    }

    public double getRating() {
        return rating;
    }

    public void addReview(String review) {
        reviews.add(review);
        System.out.println("\nReview added for " + '"' + title + '"');
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }
}