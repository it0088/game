package game.resource;

import game.resource.Audio;
import game.resource.Images;

import java.io.BufferedInputStream;

public class Sound {
    public static final ClassLoader CLASS_LOADER = Images.class.getClassLoader();

    public static Audio plainSound = new Audio(new BufferedInputStream(CLASS_LOADER.getResourceAsStream("plain.wav")));
    public static Audio boomPlainSound = new Audio(new BufferedInputStream(CLASS_LOADER.getResourceAsStream("boom.wav")));
    public static Audio boomAlienSound = new Audio(new BufferedInputStream(CLASS_LOADER.getResourceAsStream("shortboom.wav")));
    public static Audio hoursSound = new Audio(new BufferedInputStream(CLASS_LOADER.getResourceAsStream("hours.wav")));
    public static Audio raketSound = new Audio(new BufferedInputStream(CLASS_LOADER.getResourceAsStream("raket.wav")));

}
