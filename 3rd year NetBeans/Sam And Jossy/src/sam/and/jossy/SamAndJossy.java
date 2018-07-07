package sam.and.jossy;

import javax.swing.SwingUtilities;

public class SamAndJossy {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameWindow gameWindow = new GameWindow("Sam and Jossy");
                gameWindow.setVisible(true);
            }
        });
    }
}
