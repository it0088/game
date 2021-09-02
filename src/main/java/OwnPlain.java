import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OwnPlain extends Plain{
    private static final OwnPlain ownPlain = new OwnPlain();
    boolean ownPlainIsAlive = true;

    private OwnPlain()  {
        try {
            x = 50;
            y = 50;
            this.bufferedImage = ImageIO.read(Images.AIRLANE1());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OwnPlain getOwnPlain(){
        return ownPlain;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }



    class Bullet extends Plain.Bullet {

        public Bullet() {
            x = OwnPlain.this.x + 50;
            y = OwnPlain.this.y + 90;
            try {
                this.bufferedImage = ImageIO.read(Images.BULLETNONFIRE());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
