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
            ownPlain.moveBulletConsideringPlainPoint();
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
        return plain.getX() < -150 || !plain.isAlive();
    }

    public void directAndControlAlienPlainAndBullet(AlienPlain plain) {
        plain.moveLeft(2);
        whereOwnAlienAndBombAlien(plain);
        if (plain.shootingModeIsOn()) {
            plain.shootingToLeft(4);
        }else {
            plain.moveBulletConsideringPlainPoint();
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
        if ((ownPlain.getBulletX() <= 770)) {
            ownPlain.shootingToRight(4);
        } else {
            returnBulletToPlain();
        }
    }


    public void returnBulletToPlain() {
        ownPlain.moveBulletConsideringPlainPoint();
        issound = true;
        ownPlain.shootingModeOff();
    }



    public List<AlienPlain> getAliens() {
        List<AlienPlain> list = new ArrayList<>();
        list.add(new AlienPlain(950, 70 * (2 + 1)));
        return list;
    }

    public void restart() {
        this.alienPlains = getAliens();
        ownPlain.rebuild();
        crashedShips = 0;
        ownPlain.shootingModeOff();
        ownPlain.moveBulletConsideringPlainPoint();
    }

    public boolean isAliveAlien(AlienPlain plain) {
        int x = ownPlain.getBulletX() - plain.getX();
        int y = ownPlain.getBulletY() - plain.getY();

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
        if (plain.getBulletX() < -20) {
            plain.shootingModeOff();
        }
        if (plain.getY() + 5 == ownPlain.getY() + 5) {
            plain.shootingModeOn();
        }
        if ((plain.getBulletX() < ownPlain.getX() + 90 && plain.getBulletX() > ownPlain.getX()) &&
                (plain.getBulletY() > ownPlain.getY() && plain.getBulletY() < ownPlain.getY() + 70)
                || (ownPlain.getX() + 100 > plain.getX() && ownPlain.getX() < plain.getX() + 100) &&
                (ownPlain.getY() + 85 > plain.getY() && ownPlain.getY() < plain.getY() + 20)) {
            ownPlain.toDestroy();
        }
    }


}
