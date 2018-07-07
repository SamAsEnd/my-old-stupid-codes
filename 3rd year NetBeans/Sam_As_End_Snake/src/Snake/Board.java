package Snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
class Board extends JPanel{

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();
    }
    
}
