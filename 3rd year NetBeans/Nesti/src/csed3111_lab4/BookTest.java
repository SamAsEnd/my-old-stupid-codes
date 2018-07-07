package csed3111_lab4;

public class BookTest {

    public static void main(String[] args) {
        Book bookMemb = new Book("Java", "Netsi", "123456", 4.99);
        System.out.println("Book title : "+bookMemb.getBookTitle());
        System.out.println("Book Author: "+bookMemb.getAuthorName());
        System.out.println("Book ISBN  : "+bookMemb.getIsbn());
        System.out.println("Book Price : "+bookMemb.getPrice());
    }
}