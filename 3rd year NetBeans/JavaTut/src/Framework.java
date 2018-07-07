
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

class Framework extends JPanel implements KeyListener, MouseListener{

    private boolean key[];
    private boolean mouse[];
    private Graphics2D g2d;
    private Game g;
    
    public static final long secInNanosec = 1_000_000_000L;
    public static final long milisecInNanosec = 1_000_000L;
    private final int GAME_FPS = 60;
    private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;
    
    
    public Framework() {
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.black);
        
        key = new boolean[KeyEvent.KEY_LAST];
        mouse = new boolean[MouseEvent.MOUSE_LAST];
        
        if(true) // To make the mouse invisible
        {
            BufferedImage blankCursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankCursorImg, new Point(0, 0), null);
            this.setCursor(blankCursor);
        }
        this.addKeyListener(this);
        this.addMouseListener(this);
        g = new Game(g2d);
        
        Thread gameThread = new Thread() {
            @Override
            public void run(){
                gameLoop();
            }
        };
        gameThread.start();
    }

    /*public void Draw()
     * {
     * 
     * }*/

    //<editor-fold defaultstate="collapsed" desc="Key Handlers">
    public boolean getKey(int keyCode) {
        return key[keyCode];
    }
    
    @Override
    public void keyTyped(KeyEvent e) { }
    
    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mouse Handlers">
    public boolean getMouse(int mouseCode) {
        return mouse[mouseCode];
    }
    
    @Override
    public Point getMousePosition() {
        try
        {
            return super.getMousePosition();
        }
        catch (Exception e) {
            return new Point(0, 0);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { }
    
    @Override
    public void mouseEntered(MouseEvent e) { }
    
    @Override
    public void mouseExited(MouseEvent e) { }
    
    @Override
    public void mousePressed(MouseEvent e) {
        mouseStatus(e, true);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseStatus(e, false);
    }
    private void mouseStatus(MouseEvent e,boolean s) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            mouse[0] = s;
        }
        else if(e.getButton() == MouseEvent.BUTTON2) {
            mouse[1] = s;
        }
        else {
            mouse[2] = s;
        }
    }
    //</editor-fold>

    private void gameLoop() {
        while(true) {
            long beginTime = System.nanoTime();
            if(this.getKey(KeyEvent.VK_ESCAPE)) {
                System.out.println(""+KeyEvent.KEY_LAST + "  " + MouseEvent.MOUSE_LAST );
                System.exit(0);
            }
            
            repaint();
            
            
            
            long timeTaken = System.nanoTime() - beginTime;
            long timeLeft = (GAME_UPDATE_PERIOD - timeTaken) / milisecInNanosec;
            if (timeLeft < 10) 
                timeLeft = 10; //set a minimum
            try {
                 Thread.sleep(timeLeft);
            } catch (InterruptedException ex) { }
        }
    }

    @Override
    public void print(Graphics g) {
        super.paint(g);
        Draw((Graphics2D) g);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw((Graphics2D) g);
    }
    
    private void Draw(Graphics2D g) {
        super.print(g);
        g.setColor(Color.red);
        g.drawString("Sam As End", 150, 150);
        //this.g.paint();
    }
}
