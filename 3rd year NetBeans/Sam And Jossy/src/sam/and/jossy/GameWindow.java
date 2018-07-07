/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sam.and.jossy;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author SamAsEnd
 */
public class GameWindow extends JFrame {

    public GameWindow(String title) {
        super(title);
        if (true) {
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            setUndecorated(true);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        add(new GameCanvas());
    }
}
