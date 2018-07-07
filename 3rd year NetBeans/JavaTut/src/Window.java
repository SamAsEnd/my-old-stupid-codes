import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Window extends JFrame{

    public Window(){
        setTitle("Sam As End");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(new Framework());
        setVisible(true);
    }
    
    /**
     *
     * @param arg
     */
    public static void main(String[] arg){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Window g;
                g = new Window();
            }
        });
    }

}