package cseg3111.samplepackage;

import javax.swing.JOptionPane;
/*
 * Yonas getenet 2135/03
 */
public class Yonas {

    public static void main(String[] args) {
        String yon;
        yon = JOptionPane.showInputDialog(null, " enter course name");
        JOptionPane.showMessageDialog(null, yon, "course name", JOptionPane.QUESTION_MESSAGE);
    }
}
