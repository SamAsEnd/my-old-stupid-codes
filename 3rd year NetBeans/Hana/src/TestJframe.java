import java.*;
import javax.swing.*;
import java.awt.BorderLayout;
public class TestJframe {
	public static void main(String[] args){
		JFrame frame = new JFrame("this is the title of the frame ");
               	JPanel p = new JPanel();
		JButton b = new JButton("press me");
                JTextField t=new  JTextField(100);
                JLabel label1= new JLabel("Swing is best!! ");
                
		p.add(b);		// add button to panel
                p.add(t);	// add text field
                p.add(label1);	
		frame.getContentPane().add(p); // add panel to frame	        
                        
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
               frame.setVisible(true); 
                      
        }
}
