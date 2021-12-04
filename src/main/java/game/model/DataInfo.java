package game.model;

import game.model.objects.Plain;

import java.awt.image.BufferedImage;

public class DataInfo {
    Plain plain;

    public DataInfo(Plain plain) {
        this.plain = plain;
    }

    public int getX() {
        return plain.getX();
    }
    public int getY() { return plain.getY(); }
    public int getBulletX() {
        return plain.getBulletX();
    }

    public int getBulletY() {
        return plain.getBulletY();
    }

    public BufferedImage getPlainImage() {
        return plain.getPlainImage();
    }

    public BufferedImage getBulletImage() {
        return plain.getBulletImage();
    }

}
