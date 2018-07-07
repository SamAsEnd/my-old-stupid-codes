package com.samasend;

import javax.swing.SwingUtilities;

/**
 *
 * @author SamAsEnd
 */
public class SamAsEndTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TreeDraw().setVisible(true);
            }
        });
    }
}
