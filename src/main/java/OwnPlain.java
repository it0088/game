import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OwnPlain extends Plain{

    private static final OwnPlain ownPlain = new OwnPlain(50,50);

    private OwnPlain(int x, int y) {
        super(x, y);
    }


    public static OwnPlain getOwnPlain(){
        return ownPlain;
    }

}
