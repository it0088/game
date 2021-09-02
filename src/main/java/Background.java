import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background {

    public int x;
    public int y;

    public BufferedImage bombImage;

    public Background(int x, int y)  {
        this.x = x;
        this.y = y;
        try {
            this.bombImage = ImageIO.read(Images.BGG());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
