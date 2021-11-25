package game;

import game.plain.AlienPlain;
import game.plain.OwnPlain;
import game.plain.Plain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    Score score;
    OwnPlain ownPlain;
    List<AlienPlain> alienPlains;
    List<Background> imgBackground;

    public boolean canPlaySoundOfShooting = true;


    public Model() {
        score = new Score();
        imgBackground = new ArrayList<>();
        imgBackground.add(new Background(1, 1));
        imgBackground.add(new Background(1792, 1));
        setInitialSettings();

    }

    private void setInitialSettings() {
        Sound.plainSound.playSound(5);
        this.ownPlain = new OwnPlain(50, 50, Images.RED_AIRPLANE, Images.BULLETNONFIRE);
        this.alienPlains = new ArrayList<>();
        addAliens(1);
    }

    public void addAliens(int quantity) {
        Random random = new Random();

        for (int i = 0; i < quantity; i++) {
            int x = 1000 + random.nextInt(15) * 10;
            int y = random.nextInt(8) * 50;
            alienPlains.add(new AlienPlain(x, y, Images.BLUESHEEP, Images.ALIENBOMB));
        }
    }


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
            if (canPlaySoundOfShooting) {
                Sound.raketSound.playSound(0);
                canPlaySoundOfShooting = false;
            }

            if ((ownPlain.getBulletX() > 770)) {
                ownPlain.shootingModeOff();
                canPlaySoundOfShooting = true;
            } else {
                ownPlain.shootingToRight(4);
                toCheckAndChangeTheIfEnemiesPlaneIsShooted();
            }
        } else {
            ownPlain.setTheBulletPositionOnThePlane();
        }

    }

    public void toCheckAndChangeTheIfEnemiesPlaneIsShooted() {
        for (AlienPlain plain : alienPlains) {
            int x = ownPlain.getBulletX() - plain.getX();
            int y = ownPlain.getBulletY() - plain.getY();

            if ((y > -15 && y < 50) && (x < 60 && x > 15)) {
                ownPlain.shootingModeOff();
                canPlaySoundOfShooting = true;
                score.increase();
                plain.toDestroy();
                Sound.boomAlienSound.playSound(2);
            }
        }
    }


    private void simulateAnExplosionAndRestart() {
        Sound.plainSound.stop();
        Sound.boomPlainSound.playSound(0);
        JOptionPane.showMessageDialog(new JFrame(), "Game Over");
        Sound.boomPlainSound.close();
        score.calcRecord();
        score.setToZero();
        setInitialSettings();
        Sound.hoursSound.playSound(2);
    }


    public void controlAliensPlainLifeCycle() {
        for (int i = 0; i < alienPlains.size(); i++) {
            AlienPlain plain = alienPlains.get(i);
            controlAlienPlainLifeCycle(plain);
        }
    }

    private void controlAlienPlainLifeCycle(AlienPlain plain) {
        if (plain.isAlive()) {
            directAndControlAlienPlainAndBullet(plain);
        }

    }


    private void directAndControlAlienPlainAndBullet(AlienPlain plain) {
        if (plain.getX() < -150) {
            plain.toDestroy();
        } else {
            plain.moveLeft(2);
        }

        if (ownPlain.getY() + 85 > plain.getY() && ownPlain.getY() < plain.getY() + 20) {
            plain.shootingModeOn();
        }
        if (plain.shootingModeIsOn()) {
            if (plain.getBulletX() < -20) {
                plain.shootingModeOff();
            } else {
                plain.shootingToLeft(4);
                toCheckAndChangeTheIfEnemiesPlaneIsShooted(plain);
            }
        } else {
            plain.setTheBulletPositionOnThePlane();
        }
    }

    public void toCheckAndChangeTheIfEnemiesPlaneIsShooted(Plain plain) {
        if (plain.shootingModeIsOn()
                && plain.getBulletX() < ownPlain.getX() + 90
                && plain.getBulletX() > ownPlain.getX()
                && plain.getBulletY() > ownPlain.getY()
                && plain.getBulletY() < ownPlain.getY() + 70) {
            ownPlain.toDestroy();
        }
    }

    public void destroyCurrentPlainAndAddNew() {
        for (int i = 0; i < alienPlains.size(); i++) {
            AlienPlain plain = alienPlains.get(i);
            if (!plain.isAlive()) {
                alienPlains.remove(plain);
                if (alienPlains.size() <= 5) {
                    addAliens(2);
                }
            }
        }


    }


    public void detectCollisionOfPlanes() {
        if (areThePlanesCollided()) {
            ownPlain.toDestroy();
        }
    }

    private boolean areThePlanesCollided() {
        for (AlienPlain plain : alienPlains) {
            boolean iscollided = ownPlain.getX() + 100 > plain.getX()
                    && ownPlain.getX() < plain.getX() + 100
                    && ownPlain.getY() + 85 > plain.getY()
                    && ownPlain.getY() < plain.getY() + 20;

            if (iscollided) {
                return true;
            }
        }
        return false;
    }

    public void moveTheBackground() {
        Background first = imgBackground.get(0);
        Background second = imgBackground.get(1);
        boolean isTheFirstImgOutOfScreen = first.getX() + 1792 < 0;

        if (isTheFirstImgOutOfScreen) {
            int x = second.getX() + 1792;
            imgBackground.remove(first);
            first.setX(x);
            imgBackground.add(first);
        }
        first.decreaseX();
        second.decreaseX();
    }
}
