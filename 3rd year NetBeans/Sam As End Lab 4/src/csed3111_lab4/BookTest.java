package csed3111_lab4;

public class BookTest {

    public static void main(String[] args) {
        
        //int x;    //type var
        //Node* temp = new Node;
        Book bookMemb = new Book("Java", "Sam As End", "123sdcsd456789102", 99.99);
        
        System.out.println("Book Title    :" + bookMemb.getBookTitle());
        System.out.println("Book Author   :" + bookMemb.getAuthorName());
        System.out.println("Book ISBN     :" + bookMemb.getIsbn());
        System.out.println("Book Price    :" + bookMemb.getPrice());
    }
}