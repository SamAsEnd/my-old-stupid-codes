package snake;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Resource {

    private BufferedImage gameTitleImg;
    private BufferedImage menuBorderImg;
    private BufferedImage skyColorImg;
    private BufferedImage cloudLayer1Img;
    private BufferedImage cloudLayer2Img;

    public Resource() {
        try {
            URL menuBorderImgUrl = this.getClass().getResource("resources/images/menu_border.png");
            menuBorderImg = ImageIO.read(menuBorderImgUrl);

            URL skyColorImgUrl = this.getClass().getResource("resources/images/sky_color.jpg");
            skyColorImg = ImageIO.read(skyColorImgUrl);

            URL gameTitleImgUrl = this.getClass().getResource("resources/images/helicopter_battle_title.png");
            gameTitleImg = ImageIO.read(gameTitleImgUrl);

            URL cloudLayer1ImgUrl = this.getClass().getResource("resources/images/cloud_layer_1.png");
            cloudLayer1Img = ImageIO.read(cloudLayer1ImgUrl);
            URL cloudLayer2ImgUrl = this.getClass().getResource("resources/images/cloud_layer_2.png");
            cloudLayer2Img = ImageIO.read(cloudLayer2ImgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Framework.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
