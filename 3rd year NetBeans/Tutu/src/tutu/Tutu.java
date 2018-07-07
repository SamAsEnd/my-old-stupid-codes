package tutu;

import gui.kidus;

public class Tutu {

    public static void main(String[] args) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kidus().setVisible(true);
            }
        });
       
    }
}
