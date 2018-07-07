import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SamAsEnd extends JFrame {
	//----------- Buttons ------------------
	
    public JButton Calc;
    
	//----------- Text Field --------------
	
	public JTextField S;
	public JTextField E;
	public JTextField Min;
	public JTextField P;
	
	//----------- Label -------------------
	public JLabel Intro;
	public JLabel Starting;
	public JLabel Ending;
	public JLabel Price1;
	public JLabel Price;
	public JLabel Mint;
	
	//----------- Function -------------------
    
    public SamAsEnd(){
	
		//----------- Properties -------------------
		
        this.setTitle("Teshager Calculator");
        this.setSize(new Dimension( 250, 190 ));
        this.setLocation( MouseInfo.getPointerInfo().getLocation());
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.addComponentListener(new ComponentListener(){
			public void componentHidden(ComponentEvent arg0) {}
			public void componentMoved(ComponentEvent arg0) {}
			public void componentResized(ComponentEvent arg0) {}
			public void componentShown(ComponentEvent arg0){
				SamAsEnd_Load();
			}
        });
        
        this.Calc = new JButton();
        this.Calc.setText("Calculate");
        this.Calc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Sami();
			}
        });
        
      
        
        this.S = new JTextField();
        this.S.setText("\t\t");
        
        this.E = new JTextField();
        this.E.setText("\t\t");
        
        this.Min = new JTextField();
        this.Min.setText("\t\t");
        this.Min.setEditable(false);
        
        
        this.P = new JTextField();
        this.P.setText("\t\t");        
        this.P.setEditable(false);
        
        
        this.Intro = new JLabel();
        this.Intro.setText("This is Internet price calculater . . . ");
        
        this.Starting = new JLabel();
        this.Starting.setText("Starting:");
        
        this.Ending = new JLabel();
        this.Ending.setText("  Ending:");
        
        this.Price1 = new JLabel();
        this.Price1.setText("                                        ");
        
        this.Price = new JLabel();
        this.Price.setText("   Price:");
        
        this.Mint = new JLabel();
        this.Mint.setText("Minete:");
        
        add(Intro);
        add(Price1);
        add(Starting);
        add(S);
        add(Ending);
        add(E);
        add(Calc);
        add(Price1);
        add(Price);
        add(P);
        add(Mint);
        add(Min);
  
    }
    public void SamAsEnd_Load(){
    	S.setText("");
		E.setText("");
		P.setText("");
    }
    public void Sami(){
    	try{
    		double num1, num2;
    		num1 = Double.parseDouble(S.getText());
    		num2 = Double.parseDouble(E.getText());
    		
    		int h1 = (int) num1;
    		int h2 = (int) num2;
    		
    		double x1=( (double) (num1- (double) h1) *  (double) 100);
    		double x2=( (double) (num2- (double) h2) *  (double) 100);
    		
    		int min = (int) (( (h2*60)+x2) - ((h1*60)+x1 ));
    		
    		if (min<=5)
    		{
    			min=5;
    		}
    		
    		double prc = min * 0.25;
    		
    		if (h1>=24 || h1<0){
    			JOptionPane.showMessageDialog(null, "Starting Hour Num Not valid");
    			min=0;
    			prc=0;
    		}
    		
    		if (h2>=24 || h2<0){
    			JOptionPane.showMessageDialog(null, "Ending Hour Num Not valid");
    			min=0;
    			prc=0;
    		}
    		
    		if (x1>=59.999 || x1<0){
    			JOptionPane.showMessageDialog(null, "Starting Minute Num Not valid");
    			min=0;
    			prc=0;
    		}
    		if (x2>=59.999 || x2<0){
    			JOptionPane.showMessageDialog(null, "Ending Minute Num Not valid");
    			min=0;
    			prc=0;
    		}
    		if (min<=0){
    			JOptionPane.showMessageDialog(null, "Entering form ERROR!");
    			min=0;
    			prc=0;
    		}
    		
    		
    		
    		Min.setText(String.valueOf(min));
    		P.setText(String.valueOf(prc));
    	}
    	catch(Exception ex){
    		JOptionPane.showMessageDialog(null, "Invalid Number");
    	}
    }
}
