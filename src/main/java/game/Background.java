package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    public int x;
    public int y;

    public BufferedImage backgroundImage;

    public Background(int x, int y)  {
        this.x = x;
        this.y = y;
        try {
            this.backgroundImage = ImageIO.read(Images.getResource(Images.BACKGROUND));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
