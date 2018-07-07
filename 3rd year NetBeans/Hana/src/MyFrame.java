
import java.awt.*;
import javax.swing.*;

public class MyFrame extends javax.swing.JFrame {

    MyFrame(String title) {
        setTitle(title);
        setSize(400, 300);
        getContentPane().setBackground(Color.BLUE);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("MyFrame");
    }
}
