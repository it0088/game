import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class Plain {
    public BufferedImage bufferedImage;
    BufferedImage bombImage;
    int x ;
    int y ;

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

    abstract class Bullet{
        private int x ;
        private int y ;

        BufferedImage bufferedImage;


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
}
