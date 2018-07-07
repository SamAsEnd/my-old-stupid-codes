
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class Calc extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Calc().setVisible(true);
            }
        });
    }

    private JRadioButton add;
    private JRadioButton sub;
    private JRadioButton mul;
    private JRadioButton div;

    private JTextField firstNumField;
    private JTextField secondNumField;
    private JTextField answerNumField;
    private JButton calcButton;

    public Calc() {
        super("Calc");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel root = new JPanel(new GridLayout(1, 2));

        JPanel left = new JPanel(new GridLayout(4, 1));
        left.setBorder(new TitledBorder("Swing App2"));

        add = new JRadioButton("Addition");
        sub = new JRadioButton("Subtraction ");
        mul = new JRadioButton("Multiplication");
        div = new JRadioButton("Division");

        ButtonGroup group = new ButtonGroup();
        group.add(add);
        group.add(sub);
        group.add(mul);
        group.add(div);

        left.add(add);
        left.add(sub);
        left.add(mul);
        left.add(div);

        root.add(left);

        JPanel right = new JPanel(new GridLayout(4, 2));
        right.setBorder(new TitledBorder("Swing App2"));

        right.add(new JLabel("Enter first number: "));
        right.add(firstNumField = new JTextField(""));

        right.add(new JLabel("Enter second number: "));
        right.add(secondNumField = new JTextField(""));

        right.add(new JLabel("The result is: "));
        right.add(answerNumField = new JTextField(""));
        answerNumField.setEditable(false);

        right.add(new JLabel(""));
        right.add(calcButton = new JButton("  =  "));

        root.add(right);

        add(root);
        pack();

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        };

        calcButton.addActionListener(actionListener);
    }

    private void calculate() {
        try {

            double f = Double.parseDouble(firstNumField.getText());
            double s = Double.parseDouble(secondNumField.getText());

            if (add.isSelected()) {
                answerNumField.setText("" + (f + s));
            } else if (sub.isSelected()) {
                answerNumField.setText("" + (f - s));
            } else if (mul.isSelected()) {
                answerNumField.setText("" + (f * s));
            } else if (div.isSelected()) {
                answerNumField.setText("" + (f / s));
            } else {
                JOptionPane.showMessageDialog(this, "Choose an opretion!!");
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Please enter a number");
        }
    }

}
