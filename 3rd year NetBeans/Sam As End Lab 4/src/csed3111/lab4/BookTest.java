package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class BookTest {

    public static void main(String[] args) {
        Book bookMemb = new Book("C++", "Sam As End", "123456789012", 99999999999999.99);

        System.out.println("Book Title: " + bookMemb.getBookTitle());
        System.out.println("Book Author: " + bookMemb.getAuthorName());
        System.out.println("Book ISBN: " + bookMemb.getIsbn());
        System.out.println("Book Price: " + bookMemb.getPrice());
    }
}
