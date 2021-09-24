package game.plain;


import game.Direction;
import game.Images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Plain implements BulletPosition {

    private Bullet bullet;
    private Direction direction;
    private boolean isAlive = true;
    private boolean shootingModeIsOn = false;
    private BufferedImage plainImage;
    private int x;
    private int y;


    public Plain(int x, int y) {
        try {
            this.x = x;
            this.y = y;
            bullet = new Bullet();
            setTheBulletPositionOnThePlane();
            this.plainImage = ImageIO.read(Images.AIRLANE1());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toDirect() {
        if (direction == Direction.UP) {
            moveUp(2);
        } else if (direction == Direction.DOWN) {
            moveDown(2);
        } else if (direction == Direction.RIGHT) {
            moveRight(2);
        } else if (direction == Direction.LEFT) {
            moveLeft(2);
        }
    }

    public void moveUp(int speed) {
        this.y -= speed;
    }

    public void moveDown(int speed) {
        this.y += speed;
    }

    public void moveRight(int speed) {
        this.x += speed;
    }

    public void moveLeft(int speed) {
        this.x -= speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void toDestroy() {
        isAlive = false;
    }

    public void rebuild() {
        isAlive = true;
    }

    public boolean shootingModeIsOn() {
        return shootingModeIsOn;
    }

    public void shootingModeOn() {
        shootingModeIsOn = true;
        bullet.setBullet(Images.BULLET());

    }

    public void shootingModeOff() {
        shootingModeIsOn = false;
        bullet.setBullet(Images.BULLETNONFIRE());

    }

    public void shootingToRight(int speed) {
        bullet.setX(bullet.getX() + speed);
    }

    public void shootingToLeft(int speed) {
        bullet.setX(bullet.getX() - speed);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public BufferedImage getPlainImage() {
        return plainImage;
    }

    public BufferedImage getBulletImage() {
        return bullet.getBullet();
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public int getBulletX() {
        return bullet.getX();
    }


    public int getBulletY() {
        return bullet.getY();
    }


    void shiftX(int x) {
        bullet.setX(this.x + x);
    }

    void shiftY(int y) {
        bullet.setY(this.y + y);
    }


}
