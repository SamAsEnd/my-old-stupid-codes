
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 * ID: 0401343
 *
 * @author Robel Tantu
 */
public class Calculator extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    private JRadioButton add = new JRadioButton("Addition");
    private JRadioButton sub = new JRadioButton("Subtraction");
    private JRadioButton mul = new JRadioButton("Multiplication");
    private JRadioButton div = new JRadioButton("Division");
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;

    public Calculator() {
        super("Simple Calculator");
        setSize(400, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(4, 0));
        radioPanel.setBorder(new TitledBorder("Swing App2"));
        ButtonGroup group = new ButtonGroup();
        group.add(add);
        group.add(sub);
        group.add(mul);
        group.add(div);
        radioPanel.add(add);
        radioPanel.add(sub);
        radioPanel.add(mul);
        radioPanel.add(div);
        JComponent panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 0));
        panel2.add(new JLabel("Enter frist Number"));
        firstNumberField = new JTextField(10);
        firstNumberField.setHorizontalAlignment(JTextField.RIGHT);
        panel2.add(firstNumberField);
        panel2.add(new JLabel("Enter second Number"));
        secondNumberField = new JTextField(10);
        secondNumberField.setHorizontalAlignment(JTextField.RIGHT);
        panel2.add(secondNumberField);
        panel2.add(new JLabel("Result"));
        resultField = new JTextField(10);
        resultField.setHorizontalAlignment(JTextField.RIGHT);
        resultField.setEditable(false);
        panel2.add(resultField);
        panel2.add(new JLabel());
        JButton solve = new JButton("   =   ");
        panel2.add(solve);
        panel2.setBorder(new TitledBorder("Swing App2"));
        JPanel parent = new JPanel();
        parent.setLayout(new FlowLayout());
        parent.add(radioPanel, BorderLayout.WEST);
        parent.add(panel2, BorderLayout.EAST);
        add(parent);
        ActionListener solveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                solve();
            }
        };
        solve.addActionListener(solveListener);
        add.addActionListener(solveListener);
        sub.addActionListener(solveListener);
        mul.addActionListener(solveListener);
        div.addActionListener(solveListener);
        pack();
    }

    private void solve() {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            if (add.isSelected()) {
                resultField.setText("" + (firstNumber + secondNumber));
            } else if (sub.isSelected()) {
                resultField.setText("" + (firstNumber - secondNumber));
            } else if (mul.isSelected()) {
                resultField.setText("" + (firstNumber * secondNumber));
            } else if (div.isSelected()) {
                resultField.setText("" + (firstNumber / secondNumber));
            } else {
                JOptionPane.showMessageDialog(this, "Choose Oppration first!!!");
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Enter a number");
        }
    }

}
