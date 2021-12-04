package game.model.objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Bullet {

    private Point point;

    private BufferedImage bulletImage;

    public Bullet() {
        this.point = new Point(0,0);
    }

    public int getX() {
        return point.x;
    }

    public void setX(int x) {
        point.x = x;
    }

    public int getY() {
        return point.y;
    }

    public void setY(int y) {
        point.y = y;
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
