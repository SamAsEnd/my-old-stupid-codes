/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sam;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SamAsEnd
 */
public class JossyGUIOld extends JFrame{

    public JossyGUIOld() {
        setTitle("Abebe");
        setSize(654, 456);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        
        JButton jButton = new JButton("tebeda");
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "teneka", "abebe kebede", JOptionPane.INFORMATION_MESSAGE);
                //jButton.setText("New title " + System.nanoTime());
                
            }
        });
        
        
        add(jButton);
        
        setVisible(true);
    }
    
}
