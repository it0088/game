package game.plain;


import game.Direction;
import game.Images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Plain implements BulletPosition {

    private int x;
    private int y;
    private Bullet bullet;
    private Direction direction;
    private BufferedImage plainImage;
    private boolean isAlive = true;
    private boolean shootingModeIsOn = false;



    public Plain(int x, int y,String plainImg, String bulletImg) {
            this.x = x;
            this.y = y;
            this.bullet = new Bullet();
            setTheBulletPositionOnThePlane();
            setPlainImage(plainImg);
            setBulletImage(bulletImg);
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

    public void setBulletImage(String fileName)  {
        bullet.setBullet(Images.getResource(fileName));
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
        bullet.setX(this.x + x);
    }

    void shiftBulletY(int y) {
        bullet.setY(this.y + y);
    }



}
