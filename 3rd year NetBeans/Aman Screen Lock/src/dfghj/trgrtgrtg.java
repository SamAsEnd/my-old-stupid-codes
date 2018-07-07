package dfghj;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class trgrtgrtg {

    public static void main(String[] args) {
        final JFrame jFrame = new JFrame("dfc");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setUndecorated(true);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setAlwaysOnTop(true);
        jFrame.setAutoRequestFocus(true);
        jFrame.setVisible(true);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Killers");
        
        MenuItem winMenuItem = new MenuItem("Desktop");
        MenuShortcut winShortcut = new MenuShortcut(KeyEvent.VK_D,false);
        winMenuItem.setShortcut(winShortcut);
        winMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "+D");
            }
        });
        MenuItem taskMenuItem = new MenuItem("TaskManager");
        MenuShortcut taskShortcut = new MenuShortcut(KeyEvent.VK_ESCAPE,true);
        taskMenuItem.setShortcut(taskShortcut);
        taskMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "+Shift+Esc");
            }
        });
        menu.add(winMenuItem);
        menu.add(taskMenuItem);
        menuBar.add(menu);
        jFrame.setMenuBar(menuBar);

        jFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("sdf");
                jFrame.toFront();
            }
        });
    }
}
