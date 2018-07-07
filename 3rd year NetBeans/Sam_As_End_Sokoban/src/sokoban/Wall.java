package sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Wall extends Actor {

    private Image image;

    public Wall(int x, int y) {
        super(x, y);
        URL loc = this.getClass().getResource("wall.png");
        ImageIcon iia;
        iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);
    }
}