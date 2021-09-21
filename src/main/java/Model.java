import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    Random random = new Random();
    OwnPlain ownPlain = OwnPlain.getOwnPlain();
    OwnPlain.Bullet bullet = OwnPlain.getOwnPlain().new Bullet();
    List<AlienPlain> alienPlains = getAliens();


    int crashedShips;
    public int record;
    public boolean issound = true;
    public Direction direction;
    boolean canShootFromBullet = false;


    public int getRecord() {
        record = Math.max(crashedShips, record);
        return record;
    }


    public void shootFromBullet() {
        if ((bullet.getX() <= 770)) {
            bullet.setX(bullet.getX() + 4);
            bullet.setBullet(Images.BULLET());
        } else {
            returnBulletToPlain();
        }
    }

    public void setShoot(boolean shoot) {
        canShootFromBullet = shoot;
    }

    public void returnBulletToPlain() {
        moveBulletConsideringPlainPoint();
        bullet.setBullet(Images.BULLETNONFIRE());
        issound = true;
        canShootFromBullet = false;
    }

    public void moveBulletConsideringPlainPoint() {
        bullet.setX(ownPlain.x + 50);
        bullet.setY(ownPlain.y + 90);
    }


    public List<AlienPlain> getAliens() {

        List<AlienPlain> list = new ArrayList<>();
        list.add(new AlienPlain(950, 70 * (2 + 1)));
        return list;
    }

    public void restart() {
        this.alienPlains = getAliens();
        this.ownPlain.x = 50;
        this.ownPlain.y = 50;
        ownPlain.ownPlainIsAlive = true;
        crashedShips = 0;
        canShootFromBullet = false;
        moveBulletConsideringPlainPoint();
    }

    public boolean isAliveAlien(AlienPlain plain) {
        int x = bullet.getX() - plain.getX();
        int y = bullet.getY() - plain.getY();

        if ((y > -15 && y < 50) && (x < 60 && x > 15)) {
            plain.isAliveb = false;
            crashedShips++;
            return false;
        }

        return true;
    }

    public void destroyCurrentPlainAndAddNew(AlienPlain plain) {
        int x = 1000 + random.nextInt(15) * 10;
        int x2 = 1000 + random.nextInt(15) * 10;
        int y = random.nextInt(8) * 50;
        int y2 = random.nextInt(8) * 50;

        if (alienPlains.size() <= 5) {
            alienPlains.add(new AlienPlain(x, y));
            alienPlains.add(new AlienPlain(x2, y2));
        }
        alienPlains.remove(plain);

    }

    public void whereOwnAlienAndBombAlien(AlienPlain plain) {
        if (plain.xbomb < -20) {
            plain.xbomb = plain.x;
            plain.isBombShoot = false;
        }
        if (plain.y + 5 == ownPlain.y + 5) {
            plain.isBombShoot = true;
        }
        if ((plain.xbomb < ownPlain.x + 90 && plain.xbomb > ownPlain.x) &&
                (plain.ybomb > ownPlain.y && plain.ybomb < ownPlain.y + 70)
                || (ownPlain.x + 100 > plain.x && ownPlain.x < plain.x + 100) &&
                (ownPlain.y + 85 > plain.y && ownPlain.y < plain.y + 20)) {
            ownPlain.ownPlainIsAlive = false;
        }
    }

    public boolean ownPlainIsAlive() {
        return ownPlain.ownPlainIsAlive;
    }
}
