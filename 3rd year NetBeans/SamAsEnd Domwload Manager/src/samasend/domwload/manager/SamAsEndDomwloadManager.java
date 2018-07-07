package samasend.domwload.manager;

import javax.swing.SwingUtilities;

public class SamAsEndDomwloadManager {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
}
