package sam.and.jossy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameCanvas extends JPanel {

    public GameCanvas() {
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2g = (Graphics2D) g;
        setBackground(Color.BLACK);
        g.setColor(Color.red);
        g.drawString("Sam as End", 200, 100);
    }
    
    
}
