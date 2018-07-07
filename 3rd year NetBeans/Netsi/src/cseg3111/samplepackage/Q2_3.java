package cseg3111.samplepackage;

/*
 * Netsanet Hailu
 * ID 0401282
 */

import javax.swing.JOptionPane;

public class Q2_3 {

    public static void main(String[] args) {
        String courseName = JOptionPane.showInputDialog(null, "Course Name", "Enter your course name", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, courseName, "The Name of the course is: ", JOptionPane.INFORMATION_MESSAGE);
    }
}
