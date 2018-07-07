package Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener, MouseListener{
    
    
    
    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        super("Sam As End");
        init();
        setSize(1366, 768);
        
        setResizable(false);
        setVisible(false);
        
    }
    
    private boolean key[];
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;
    }
    
    private boolean mouse[];
    
    @Override
    public void mouseClicked(MouseEvent e) {
        changeMouseStat(e.getKeyCo, rootPaneCheckingEnabled);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    private void changeMouseStat(int mouseCode,boolean stat) {
        if(mouseCode == MouseEvent.BUTTON1) {
            mouse[0] = stat;
        }
        else if(mouseCode == MouseEvent.BUTTON2) {
            mouse[1] = stat;
        }
        else {
            mouse[2] = stat;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    private void init() {
        URL bg = this.getClass().getResource("res/");
        
    }
}
