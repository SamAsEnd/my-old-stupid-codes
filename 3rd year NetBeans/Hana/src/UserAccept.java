
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class UserAccept {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        
        Scanner cin = new Scanner(System.in);
        
        String temp = JOptionPane.showInputDialog(null, "What  ?");
        
        JOptionPane.showMessageDialog(null, temp);
        
    }

}
