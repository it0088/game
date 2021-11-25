package game;

import game.plain.AlienPlain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {
    Font font;

    KeyController keyController;

    public View(KeyController keyController) {
        super("Clash of Aliens");
        this.keyController = keyController;
        this.font = new Font("Impact", Font.BOLD, 30);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 100, 950, 500);
        setVisible(true);
        add(gameMotion);
        addKeyListener(keyController);

    }

    JComponent gameMotion = new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D d2 = ((Graphics2D) g);
            d2.setFont(font);


            d2.drawImage(keyController.model.imgBackground.get(0).getBackgroundImage(), keyController.model.imgBackground.get(0).getX(), keyController.model.imgBackground.get(0).getY(), null);
            d2.drawImage(keyController.model.imgBackground.get(1).getBackgroundImage(), keyController.model.imgBackground.get(1).getX(), keyController.model.imgBackground.get(1).getY(), null);

            d2.drawString("Crashed ships: " + keyController.model.score.getScore(), 20, 50);
            d2.drawString("Record : " + keyController.model.score.getRecord(), 400, 50);

            d2.drawImage(keyController.getModel().ownPlain.getPlainImage(),
                    keyController.getModel().ownPlain.getX(),
                    keyController.getModel().ownPlain.getY(), null);
            d2.drawImage(keyController.getModel().ownPlain.getBulletImage(),
                    keyController.getModel().ownPlain.getBulletX(),
                    keyController.getModel().ownPlain.getBulletY(), null);

            for (int i = 0; i < keyController.model.alienPlains.size(); i++) {
                AlienPlain plain = keyController.getModel().alienPlains.get(i);
                d2.drawImage(plain.getBulletImage(), plain.getBulletX(), plain.getBulletY(), null);
                d2.drawImage(plain.getPlainImage(), plain.getX(), plain.getY(), null);

            }

        }
    };

}
