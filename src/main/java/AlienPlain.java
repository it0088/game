import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class AlienPlain extends Plain {

    int xbomb;
    int ybomb;


    boolean isAliveb = true;
    boolean isBombShoot = false;

    AlienPlain  (int x, int y) {

        xbomb = x ;
        ybomb = y ;

        try {
            this.bombImage = ImageIO.read(Images.ALIENBOMB());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
        try {
            this.bufferedImage = ImageIO.read(Images.ALIEN2());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }


}

