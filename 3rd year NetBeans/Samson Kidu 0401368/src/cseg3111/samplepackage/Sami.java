package cseg3111.samplepackage;

/*'
 * Samson Kidu 0401368
 */
import javax.swing.JOptionPane;

public class Sami {

    public static void main(String[] args) {
        String courseName = JOptionPane.showInputDialog(null, "Course Name", "Enter your course name", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, courseName, "The Name of the course is: ", JOptionPane.INFORMATION_MESSAGE);
    }
}
