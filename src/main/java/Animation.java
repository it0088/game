import javax.swing.*;


public class Animation extends Thread {
    private View view;
    private Model model;

    public Animation(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void delayProcces(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        Sound.plainSound.playSound(5);
        while (true) {
            controlAirPlaneLifeCycle();

            actionOverAirplaneBullet();

            controlAliensPlainLifeCycle();

            delayProcces(10);

            view.repaint();
        }
    }



    public void controlAirPlaneLifeCycle() {
        if (model.ownPlainIsAlive()) {
            if (model.direction == Direction.UP) {
                model.ownPlain.y -= 2;
            } else if (model.direction == Direction.DOWN) {
                model.ownPlain.y += 2;
            } else if (model.direction == Direction.RIGHT) {
                model.ownPlain.x += 2;
            } else if (model.direction == Direction.LEFT) {
                model.ownPlain.x -= 2;
            } else if (model.direction == Direction.ESC) {
                System.exit(0);
            }
        } else {
            Sound.plainSound.stop();
            model.direction = Direction.STOP;
            Sound.boomPlainSound.playSound(0);
            JOptionPane.showMessageDialog(view, "Game Over");
            Sound.boomPlainSound.close();
            model.restart();
            Sound.hoursSound.playSound(2);
        }
    }

    public void actionOverAirplaneBullet() {
        if (model.canShootFromBullet) {
            model.shootFromBullet();
            if (model.issound) Sound.raketSound.playSound(0);
            model.issound = false;
        } else {
            model.issound = true;
            model.returnBulletToPlain();

        }
    }


    public void controlAliensPlainLifeCycle() {
        for (int i = 0; i < model.countAliens; i++) {
            AlienPlain plain = model.alienPlains.get(i);
            controlAlienPlainLifeCycle(plain);
        }
    }

    public void controlAlienPlainLifeCycle(AlienPlain plain) {
        if (isAlienPlainOutOfBound(plain)) {
            model.destroyCurrentPlainAndAddNew(plain);
        } else if (model.isAliveAlien(plain)) {
            directAndControlAlienPlainAndBullet(plain);
        } else {
            simulateAnExplosionAndRemoveAlienPlain(plain);
            if (model.countAliens < 5)
                model.countAliens++;
        }

    }
    public boolean isAlienPlainOutOfBound(AlienPlain plain) {
        return plain.x < -150;
    }

    public void directAndControlAlienPlainAndBullet(AlienPlain plain) {
        plain.x -= 2;
        model.whereOwnAlienAndBombAlien(plain);
        if (plain.isBombShoot) {
            plain.xbomb -= 5;
        } else {
            plain.xbomb -= 2;
        }
    }

    public void simulateAnExplosionAndRemoveAlienPlain(AlienPlain plain) {
        Sound.boomAlienSound.playSound(1);
        model.returnBulletToPlain();
        view.repaint();
        delayProcces(75);
        model.destroyCurrentPlainAndAddNew(plain);
    }





}
