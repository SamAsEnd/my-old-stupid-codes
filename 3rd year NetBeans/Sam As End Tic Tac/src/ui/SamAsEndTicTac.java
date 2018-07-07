package ui;
import ui.newGame;

public class SamAsEndTicTac {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new newGame().setVisible(true);      
            }
        });
    }
}
