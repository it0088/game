import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class Plain {
    public BufferedImage plainImage;
    BufferedImage bulletImage;
    int x;
    int y;

    Bullet bullet;
    public Direction direction;
    private boolean isAlive = true;
    private boolean shootingModeIsOn = false;


    public Plain(int x,int y)  {
        try {
            this.x = x;
            this.y = y;
            bullet = new Bullet(x+50,y+90);
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


    public BufferedImage getBufferedImage() {
        return plainImage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
