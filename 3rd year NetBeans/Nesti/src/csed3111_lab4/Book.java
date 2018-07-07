package csed3111_lab4;

public class Book {

    private String bookTitle;
    private String authorName; 
    private String isbn;
    private double price;

    public Book(String bt, String authorName, String isbn, double price) {
        bookTitle = bt;
        this.authorName = authorName;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
}