package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Background {

    private int x;
    private int y;
    private BufferedImage backgroundImage;

    public Background(int x, int y)  {
        this.x = x;
        this.y = y;
        try {
            this.backgroundImage = ImageIO.read(Images.getResource(Images.BACKGROUND));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void decreaseX(){
        x--;
    }
    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }



}
