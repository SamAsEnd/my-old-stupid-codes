package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class Book {

    private String bookTitle;
    private String authorName;
    private String isbn;
    private double price;

    public Book(String bookTitle, String authorName, String isbn, double price) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
