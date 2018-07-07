package com.samasend.webbrowser;

import java.awt.EventQueue;

/**
 *
 * @author SamAsEnd
 */
public class SamAsEndWebBrowser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BrowserWindow().setVisible(true);
            }
        });
    }
}
