import javax.swing.*;
import java.io.IOException;


public class Animation extends Thread {
    private View view;
    private Model model;

    public Animation(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void run() {
        Sound.plainSound.playSound(5);
        while (true){
            if (model.ownPlainIsAlive()) {
                if(model.direction == Direction.UP){
                    model.ownPlain.y-=2;
                }
                else if(model.direction == Direction.DOWN){
                    model.ownPlain.y+=2;
                }
                else if(model.direction == Direction.RIGHT){
                    model.ownPlain.x+=2;
                }
                else if(model.direction == Direction.LEFT){
                    model.ownPlain.x-=2;
                }
                else if(model.direction == Direction.ESC){
                    System.exit(0);
                }
            }else{
                Sound.plainSound.stop();
                model.direction = Direction.STOP;
                Sound.boomPlainSound.playSound(0);
                JOptionPane.showMessageDialog(view, "Game Over");
                Sound.boomPlainSound.close();
                model.restart();
                Sound.hoursSound.playSound(2);
                continue;
            }

            if(model.isShoot){

                try {
                    model.shootFromBullet();
                    if(model.issound)Sound.raketSound.playSound(0);
                    model.issound  = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    model.issound  = true;
                    model.bulletToPlain();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < model.countAliens; i++) {
                AlienPlain plain = model.alienPlains.get(i);

                if(plain.x < -150 && !model.isShoot){
                    model.bombAlien(plain);
                }
                else if(!model.isAliveAlien(plain)){
                    try {
                        model.bulletToPlain();
                        model.isShoot = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Sound.boomAlienSound.playSound(1);
                    view.repaint();
                    try {
                        sleep(75);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    model.bombAlien(plain);
                    if(model.countAliens<5)
                        model.countAliens++;

                }

                else {
                    if (Sound.hoursSound.ais==null && Sound.hoursSound.clip==null ||!Sound.hoursSound.isActive()) {
                        Sound.plainSound.start();
                        plain.x-=2;
                        model.whereOwnAlienAndBombAlien(plain);
                        if (plain.isBombShoot) {
                            plain.xbomb -= 5;
                        } else {
                            plain.xbomb-=2;
                        }
                    }
                }
            }
            view.repaint();
        }
    }
}
