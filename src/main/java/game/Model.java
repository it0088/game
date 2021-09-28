package game;

import game.plain.AlienPlain;
import game.plain.OwnPlain;

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
            ownPlain.toDirect();
            actionOverAirplaneBullet();
        } else {
            simulateAnExplosionAndRestart();
        }
    }


    private void actionOverAirplaneBullet() {
        if (ownPlain.shootingModeIsOn()) {
            if (issound) {
                Sound.raketSound.playSound(0);
                issound = false;
            }
            ownPlain.shootingToRight(4);
        } else {
            ownPlain.setTheBulletPositionOnThePlane();
        }
    }

    private void simulateAnExplosionAndRestart() {
        Sound.plainSound.stop();
        ownPlain.setDirection(Direction.STOP);
        Sound.boomPlainSound.playSound(0);
        JOptionPane.showMessageDialog(new JFrame(), "Game Over");
        Sound.boomPlainSound.close();
        restart();
        Sound.hoursSound.playSound(2);
    }

    public void restart() {
        crashedShips = 0;
        alienPlains = getAliens();
        ownPlain.rebuild();
        ownPlain.shootingModeOff();
        ownPlain.setBulletImage(Images.BULLETNONFIRE);
        ownPlain.setTheBulletPositionOnThePlane();
    }

    public void controlAliensPlainLifeCycle() {
        for (int i = 0; i < alienPlains.size(); i++) {
            AlienPlain plain = alienPlains.get(i);
            controlAlienPlainLifeCycle(plain);
        }
    }

    private void controlAlienPlainLifeCycle(AlienPlain plain) {
        if (isAliveAlien(plain)) {
            directAndControlAlienPlainAndBullet(plain);
        } else {
            destroyCurrentPlainAndAddNew(plain);
        }

    }

    private boolean isAliveAlien(AlienPlain plain) {
        return plain.isAlive();
    }

    private void directAndControlAlienPlainAndBullet(AlienPlain plain) {
        plain.moveLeft(2);
        if (plain.shootingModeIsOn()) {
            plain.shootingToLeft(4);
        } else {
            plain.setTheBulletPositionOnThePlane();
        }
    }

    private void destroyCurrentPlainAndAddNew(AlienPlain plain) {
        alienPlains.remove(plain);
        int x = 1000 + random.nextInt(15) * 10;
        int x2 = 1000 + random.nextInt(15) * 10;
        int y = random.nextInt(8) * 50;
        int y2 = random.nextInt(8) * 50;

        if (alienPlains.size() <= 5) {
            alienPlains.add(new AlienPlain(x, y, Images.BLUESHEEP, Images.ALIENBOMB));
            alienPlains.add(new AlienPlain(x2, y2, Images.BLUESHEEP, Images.ALIENBOMB));
        }

    }


    public List<AlienPlain> getAliens() {
        List<AlienPlain> list = new ArrayList<>();
        list.add(new AlienPlain(950, 70 * (2 + 1), Images.BLUESHEEP, Images.ALIENBOMB));
        return list;
    }




    public void whereOwnAlienAndBombAlien() {

        for (AlienPlain plain : alienPlains) {

            int x = ownPlain.getBulletX() - plain.getX();
            int y = ownPlain.getBulletY() - plain.getY();

            if ((y > -15 && y < 50) && (x < 60 && x > 15)) {
                plain.toDestroy();
                ownPlain.shootingModeOff();
                issound = true;
                Sound.boomAlienSound.playSound(2);
                crashedShips++;
            } else if (plain.getX() < -150) {
                plain.toDestroy();
            }
            if ((ownPlain.getBulletX() > 770)) {
                ownPlain.shootingModeOff();
                issound = true;

            }

            if (plain.getBulletX() < -20) {
                plain.shootingModeOff();

            } else if (plain.getY() + 5 == ownPlain.getY() + 5) {
                plain.shootingModeOn();
            }
            if (plain.shootingModeIsOn() && (plain.getBulletX() < ownPlain.getX() + 90 && plain.getBulletX() > ownPlain.getX()) &&
                    (plain.getBulletY() > ownPlain.getY() && plain.getBulletY() < ownPlain.getY() + 70)
                    || (ownPlain.getX() + 100 > plain.getX() && ownPlain.getX() < plain.getX() + 100) &&
                    (ownPlain.getY() + 85 > plain.getY() && ownPlain.getY() < plain.getY() + 20)) {
                ownPlain.toDestroy();
            }
        }
    }



    public int getRecord() {
        record = Math.max(crashedShips, record);
        return record;
    }


}
