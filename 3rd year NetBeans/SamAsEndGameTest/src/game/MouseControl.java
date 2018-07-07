package game;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseControl extends MouseAdapter {

    private static Point p;
    private static int[] mouse;
    public MouseControl() {
        p = new Point(0, 0);
        mouse = new int[6];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        p = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        p = e.getPoint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        p = e.getPoint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        p = e.getPoint();}

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        p = e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        p = e.getPoint();
        mouse[e.getButton()] = 2;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        p = e.getPoint();
        mouse[e.getButton()] --;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
        p = e.getPoint();
    }
    
    public static boolean isPressed(int m) {
        if(mouse[m] == 0) {
            return false;
        }
        else {
            mouse[m] --;
            return true;
        }
    }
}
