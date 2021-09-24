import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    Random random = new Random();
    OwnPlain ownPlain = OwnPlain.getOwnPlain();

    List<AlienPlain> alienPlains = getAliens();


    int crashedShips;
    public int record;
    public boolean issound = true;



    public void controlAirPlaneLifeCycle() {
        if (ownPlain.isAlive()) {
            performKeyEventFromUser();
        } else {
            simulateAnExplosionAndRestart();
        }
    }

    public void performKeyEventFromUser() {
        ownPlain.toDirect();
    }




    public void simulateAnExplosionAndRestart() {
        Sound.plainSound.stop();
        ownPlain.setDirection(Direction.STOP);
        Sound.boomPlainSound.playSound(0);
        JOptionPane.showMessageDialog(new JFrame(), "Game Over");
        Sound.boomPlainSound.close();
        restart();
        Sound.hoursSound.playSound(2);
    }



    public void actionOverAirplaneBullet() {
        if (ownPlain.shootingModeIsOn()) {
            if (issound) {
                Sound.raketSound.playSound(0);
                issound = false;
            }
            shootingFromBullet();
        } else {
            moveBulletConsideringPlainPoint();
        }
    }


    public void controlAliensPlainLifeCycle() {
        for (int i = 0; i < alienPlains.size(); i++) {
            AlienPlain plain = alienPlains.get(i);
            controlAlienPlainLifeCycle(plain);
        }
    }

    public void controlAlienPlainLifeCycle(AlienPlain plain) {
        if (isAlienPlainOutOfBoundOrNoAlive(plain)) {
            destroyCurrentPlainAndAddNew(plain);
        } else if (isAliveAlien(plain)) {
            directAndControlAlienPlainAndBullet(plain);
        } else {
            simulateAnExplosionAndRemoveAlienPlain(plain);

        }

    }
    public boolean isAlienPlainOutOfBoundOrNoAlive(AlienPlain plain) {
        return plain.x < -150 || !plain.isAlive();
    }

    public void directAndControlAlienPlainAndBullet(AlienPlain plain) {
        plain.moveLeft(2);
        whereOwnAlienAndBombAlien(plain);
        if (plain.shootingModeIsOn()) {
            plain.s;
        } else {
            plain.xbomb -= 2;
        }
    }

    public void simulateAnExplosionAndRemoveAlienPlain(AlienPlain plain) {
        Sound.boomAlienSound.playSound(1);
        returnBulletToPlain();


    }


    public int getRecord() {
        record = Math.max(crashedShips, record);
        return record;
    }


    public void shootingFromBullet() {
        if ((ownPlain.bullet.getX() <= 770)) {
            ownPlain.shootingToRight(4);
        } else {
            returnBulletToPlain();
        }
    }


    public void returnBulletToPlain() {
        moveBulletConsideringPlainPoint();
        ownPlain.bullet.setBullet(Images.BULLETNONFIRE());
        issound = true;
        ownPlain.shootingModeOff();
    }

    public void moveBulletConsideringPlainPoint() {
        ownPlain.bullet.setX(ownPlain.x + 50);
        ownPlain.bullet.setY(ownPlain.y + 90);
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
        ownPlain.rebuild();
        crashedShips = 0;
        ownPlain.shootingModeOff();
        moveBulletConsideringPlainPoint();
    }

    public boolean isAliveAlien(AlienPlain plain) {
        int x = ownPlain.bullet.getX() - plain.getX();
        int y = ownPlain.bullet.getY() - plain.getY();

        if ((y > -15 && y < 50) && (x < 60 && x > 15)) {
            crashedShips++;
            return false;
        }

        return true;
    }

    public void destroyCurrentPlainAndAddNew(AlienPlain plain) {
        alienPlains.remove(plain);
        int x = 1000 + random.nextInt(15) * 10;
        int x2 = 1000 + random.nextInt(15) * 10;
        int y = random.nextInt(8) * 50;
        int y2 = random.nextInt(8) * 50;

        if (alienPlains.size() <= 5) {
            alienPlains.add(new AlienPlain(x, y));
            alienPlains.add(new AlienPlain(x2, y2));
        }

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
            ownPlain.toDestroy();
        }
    }


}
