package game.model.objects;


import game.controller.Direction;
import game.model.DataInfo;
import game.resource.Images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Plain implements BulletPosition {

    private Point point;
    private Bullet bullet;
    private Direction Direction;
    private BufferedImage plainImage;
    DataInfo dataInfo;
    private boolean isAlive = true;
    private boolean shootingModeIsOn = false;


    public Plain(int x, int y, String plainImg, String bulletImg) {
        this.point = new Point(x, y);
        this.bullet = new Bullet();
        setTheBulletPositionOnThePlane();
        setPlainImage(plainImg);
        setBulletImage(bulletImg);
        this.dataInfo = new DataInfo(this);
    }


    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public int getBulletX() {
        return bullet.getX();
    }

    public int getBulletY() {
        return bullet.getY();
    }

    public BufferedImage getPlainImage() {
        return plainImage;
    }

    public BufferedImage getBulletImage() {
        return bullet.getBullet();
    }


    public void setPlainImage(String fileName) {
        try {
            plainImage = ImageIO.read(Images.getResource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBulletImage(String fileName) {
        bullet.setBullet(Images.getResource(fileName));
    }

    public void setDirection(Direction Direction) {
        this.Direction = Direction;
    }


    public void toDirect() {
        if (Direction == Direction.UP) {
            moveUp(2);
        } else if (Direction == Direction.DOWN) {
            moveDown(2);
        } else if (Direction == Direction.RIGHT) {
            moveRight(2);
        } else if (Direction == Direction.LEFT) {
            moveLeft(2);
        }
    }

    public void moveUp(int speed) {
        point.y -= speed;
    }

    public void moveDown(int speed) {
        point.y += speed;
    }

    public void moveRight(int speed) {
        point.x += speed;
    }

    public void moveLeft(int speed) {
        point.x -= speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void toDestroy() {
        isAlive = false;
    }


    public boolean shootingModeIsOn() {
        return shootingModeIsOn;
    }

    public void shootingModeOn() {
        shootingModeIsOn = true;
    }

    public void shootingModeOff() {
        shootingModeIsOn = false;
    }

    public void shootingToRight(int speed) {
        bullet.setX(bullet.getX() + speed);
    }

    public void shootingToLeft(int speed) {
        bullet.setX(bullet.getX() - speed);
    }

    void shiftBulletX(int x) {
        bullet.setX(point.x + x);
    }

    void shiftBulletY(int y) {
        bullet.setY(point.y + y);
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }
}
