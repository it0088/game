import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Bullet {
        private int x ;
        private int y ;

        BufferedImage bufferedImage;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
            try {
                this.bufferedImage = ImageIO.read(Images.BULLETNONFIRE());
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

        public void setBullet(InputStream image)  {
            try {
                this.bufferedImage = ImageIO.read(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
