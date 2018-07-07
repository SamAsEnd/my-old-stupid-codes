package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter{

    private static int[] key;
    
    public KeyControl() {
        key = new int[525];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        key[e.getKeyCode()] = 2;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        key[e.getKeyCode()] --;
    }

    @Override
    public void keyTyped(KeyEvent e) { }
    
    public static boolean isPressed(int k) {
        if(key[k] == 0) {
            return false;
        }
        else {
            key[k] --;
            return true;
        }
    }
}
