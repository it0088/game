package game.resource;

import java.io.InputStream;

public class Images {

    public static final ClassLoader CLASS_LOADER = Images.class.getClassLoader();

    public static final String ALIENBOMB = "alienbomb.png";
    public static final String BLUESHEEP = "blueSheep.png";
    public static final String BACKGROUND = "bgg.png";
    public static final String FIRE_BULLET = "bullet_with_fire.png";
    public static final String BULLETNONFIRE = "bulletnonfire.png";
    public static final String RED_AIRPLANE = "red_airplane.png";
    public static final String BOOM = "boom.png";

    public static InputStream getResource(String fileName) {
        return CLASS_LOADER.getResourceAsStream(fileName);
    }

}
