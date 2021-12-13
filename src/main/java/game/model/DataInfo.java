package game.model;

import game.model.objects.Plane;

import java.awt.image.BufferedImage;

public class DataInfo {
    Plane plane;

    public DataInfo(Plane plane) {
        this.plane = plane;
    }

    public int getX() {
        return plane.getX();
    }
    public int getY() { return plane.getY(); }
    public int getBulletX() {
        return plane.getBulletX();
    }

    public int getBulletY() {
        return plane.getBulletY();
    }

    public BufferedImage getPlainImage() {
        return plane.getPlainImage();
    }

    public BufferedImage getBulletImage() {
        return plane.getBulletImage();
    }

}
