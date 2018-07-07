package samasendclock;

import java.awt.EventQueue;

public class SamAsEndClock {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Clock clock = new Clock();
                clock.setVisible(true);
            }
        });
    }
}
