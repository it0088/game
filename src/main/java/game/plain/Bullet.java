package game.plain;

import game.Images;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Bullet {
    private int x;
    private int y;

    private BufferedImage bulletImage;

    public Bullet() {
        try {
            this.bulletImage = ImageIO.read(Images.BULLETNONFIRE());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setBullet(InputStream image) {
        try {
            this.bulletImage = ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBullet() {
        return bulletImage;
    }
}
