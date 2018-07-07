
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *   Sam As End
 * 
 * @author Sam As End
 */
class Game {
    
    private Graphics2D g;
    private Image bg;
    private int i = 0;
    public Game(Graphics2D g) {
        this.g = g;
        loadRes();
    }

    private void loadRes() {
        URL bgRes = this.getClass().getResource("/res/bg.png");
        try {
            this.bg = ImageIO.read(bgRes);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void paint() {
        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", Font.ITALIC, 50));
        g.drawImage(bg, 0, 0, 1366, 768, null);
        g.drawString("My best program EVER Mather Fuker Java 2D nigger", i++, 350);
        if(i>=768) {
            i = 0;
        }
    }

    
    
    
}
