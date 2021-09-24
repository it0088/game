package game;

import java.io.InputStream;

public class Images {

    public static final ClassLoader CLASS_LOADER = Images.class.getClassLoader();


    public static InputStream ALIENBOMB() {
        return CLASS_LOADER.getResourceAsStream("alienbomb.png");
    }

    public static InputStream ALIEN2() {
        return CLASS_LOADER.getResourceAsStream("alien2.png");
    }

    public static InputStream BGG() {
        return CLASS_LOADER.getResourceAsStream("bgg.png");
    }

    public static InputStream BULLET() {
        return CLASS_LOADER.getResourceAsStream("bullet.png");
    }

    public static InputStream BULLETNONFIRE() {
        return CLASS_LOADER.getResourceAsStream("bulletnonfire.png");
    }

    public static InputStream AIRLANE1() {
        return CLASS_LOADER.getResourceAsStream("airlane1.png");
    }

    public static InputStream BOOM1() {
        return CLASS_LOADER.getResourceAsStream("boom1.png");
    }


//    public static final InputStream ALIEN2 = CLASS_LOADER.getResourceAsStream("alien2.png");
//    public static final InputStream BGG = CLASS_LOADER.getResourceAsStream("bgg.png");
//    public static final InputStream BULLET = CLASS_LOADER.getResourceAsStream("bullet.png");
//    public static final InputStream BULLETNONFIRE = CLASS_LOADER.getResourceAsStream("bulletnonfire.png");
//    public static final InputStream AIRLANE1 = CLASS_LOADER.getResourceAsStream("airlane1.png");
//    public static final InputStream BOOM1 = CLASS_LOADER.getResourceAsStream("boom1.png");


}
