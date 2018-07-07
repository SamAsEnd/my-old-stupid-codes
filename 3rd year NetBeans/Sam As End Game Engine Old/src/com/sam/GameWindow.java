package com.sam;

import javax.swing.JFrame;

class GameWindow extends JFrame {

    public GameWindow() {
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
