
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Zinu extends JFrame {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("GUI");
        JPanel check = new JPanel(new GridLayout(2, 1));
        JCheckBox check1 = new JCheckBox("One");
        JCheckBox check2 = new JCheckBox("Two");
        check.add(check1);
        check.add(check2);
        frame.add(check, BorderLayout.WEST);
        JPanel label = new JPanel(new GridLayout(2, 1));
        final JLabel label1 = new JLabel("MID MARK");
        JLabel label2 = new JLabel("LAB MARK");
        final JTextField text1 = new JTextField(10);
        final JTextField text2 = new JTextField(10);
        label.add(label1);
        label.add(text1);
        label.add(label2);
        label.add(text2);
        frame.add(label, BorderLayout.NORTH);
        JPanel button = new JPanel(new GridLayout(3, 1));
        JButton but1 = new JButton("Ok");
        JButton but2 = new JButton("Cancel");
        JButton but3 = new JButton("Help");
        label.setBorder(new TitledBorder("group checkbox"));
        ButtonGroup labels = new ButtonGroup();
        labels.add(but1);
        labels.add(but2);
        labels.add(but3);
        button.add(but1);
        button.add(but2);
        button.add(but3);
        frame.add(button, BorderLayout.EAST);
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber
                        = JOptionPane.showInputDialog(null, "Enter Mid Mark");
                String secondNumber
                        = JOptionPane.showInputDialog(null, "Enter Lab Mark");
                double number1 = Double.parseDouble(firstNumber);
                text1.setText("" + number1);
                double number2 = Integer.parseInt(secondNumber);
                text2.setText("" + number2);
            }
        });
    }
}
