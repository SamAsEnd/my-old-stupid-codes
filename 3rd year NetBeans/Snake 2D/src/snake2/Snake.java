package snake2;

import javax.swing.JFrame;

public class Snake extends JFrame {

    public Snake() {
        Board board = new Board();
        add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 340);
        setLocationRelativeTo(null);
        setTitle("Samson Endale Snake");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        Snake snake = new Snake();
    }
    
    public static void Reset() {
        new Snake();
    }
}